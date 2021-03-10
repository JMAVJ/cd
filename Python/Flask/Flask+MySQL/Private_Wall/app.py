from flask import Flask, render_template, request, redirect, flash, session
from flask_bcrypt import Bcrypt
import re
from mysqlconnection import connectToMySQL


app = Flask(__name__)

app.secret_key = 'SecretKey'

bcrypt = Bcrypt(app)

DATABASE_NAME = 'private_wall'


@app.route('/')
def index():
    if session.get('user_id') is None:
        return redirect('/auth')

    data = {
        'user_id': session.get('user_id'),
    }

    mysql = connectToMySQL(DATABASE_NAME)
    query = 'SELECT messages.id, message, sent_to, sent_by, concat(first_name, " ", last_name) as sender FROM `messages` INNER JOIN users WHERE users.id = messages.sent_by AND messages.sent_to = %(user_id)s'

    messages = mysql.query_db(query, data)
    message_quantity = len(messages)

    mysql = connectToMySQL(DATABASE_NAME)
    query = 'SELECT id, concat(`first_name`, " ", `last_name`) as `name` FROM `users` WHERE NOT `id` = %(user_id)s'
    users = mysql.query_db(query, data)

    mysql = connectToMySQL(DATABASE_NAME)
    query = 'SELECT message FROM MESSAGES WHERE `sent_by` = %(user_id)s'
    sent_messages = mysql.query_db(query, data)
    sent_messages = len(sent_messages)

    return render_template(
        'index.html',
        messages=messages,
        message_quantity=message_quantity,
        users=users,
        sent_messages=sent_messages
    )


@app.route('/message/send', methods=['POST'])
def send_message():
    if len(request.form['message']) < 1:
        flash('You can not send an empty message')
        return redirect('/')

    data = {
        'message': request.form['message'],
        'sent_by': session.get('user_id'),
        'sent_to': request.form['send_to'],
    }

    query = 'INSERT INTO `messages` (message, sent_by, sent_to) VALUES (%(message)s, %(sent_by)s, %(sent_to)s)'

    mysql = connectToMySQL(DATABASE_NAME)
    mysql.query_db(query, data)
    return redirect('/')


@app.route('/message/delete/<int:message_id>', methods=['DELETE'])
def delete_message(message_id):
    mysql = connectToMySQL(DATABASE_NAME)
    query = 'DELETE FROM messages WHERE id = %(message_id)s'
    data = {
        'message_id': message_id,
    }
    result = mysql.query_db(query, data)
    return 'Ok'


@app.route('/messages')
def get_messages():
    mysql = connectToMySQL(DATABASE_NAME)
    query = 'SELECT messages.id, message, sent_to, sent_by, concat(first_name, " ", last_name) as sender FROM `messages` INNER JOIN users WHERE users.id = messages.sent_by AND messages.sent_to = %(user_id)s'
    data = {
        'user_id': session['user_id'],
    }
    messages = mysql.query_db(query, data)
    return {
        'data': messages,
    }


@app.route('/auth')
def auth():
    return render_template('auth.html')


@app.route('/sign-in', methods=['POST'])
def sign_in():
    mysql = connectToMySQL(DATABASE_NAME)
    data = {
        'email': request.form['email'],
        'password': request.form['password']
    }

    query = 'SELECT * FROM `users` WHERE email = %(email)s'
    acc = mysql.query_db(query, data)

    if len(acc) < 1:
        flash('Wrong email or password')
        return redirect('/auth')

    if not bcrypt.check_password_hash(acc[0]['password'], data['password']):
        flash('Wrong email or password')
        return redirect('/auth')

    session['user_id'] = acc[0]['id']
    session['email'] = acc[0]['email']

    return redirect('/')


@app.route('/sign-out')
def sign_out():
    session.clear()
    return redirect('/')


@app.route('/register', methods=['POST'])
def register():
    data = {
        'first_name': request.form['first_name'],
        'last_name': request.form['last_name'],
        'email': request.form['email'],
        'password': request.form['password'],
        'password_confirmation': request.form['password_confirmation'],
    }

    # Data Validation
    EMAIL_REGEX = re.compile(
        r'^[a-z-A-Z0-9.+_-]+@[a-z-A-Z0-9.+_-]+\.[a-zA-Z]+$')
    if not EMAIL_REGEX.match(data['email']):
        flash('The email must be valid')
        return redirect('/auth')

    if len(data['first_name']) < 2 or len(data['last_name']) < 2:
        flash('First and last name must be at least 2 characters long')
        return redirect('/auth')

    if len(data['password']) < 8:
        flash('The password must be at least 8 characters long')
        return redirect('/auth')

    if data['password'] != data['password_confirmation']:
        flash('Passwords do not match')
        return redirect('/auth')

    # DB Connection
    mysql = connectToMySQL(DATABASE_NAME)

    # Check if email is already registered
    query = 'SELECT * FROM `users` WHERE `email` = %(email)s'
    accounts = mysql.query_db(query, data)
    if len(accounts) > 0:
        flash(f"Email {data['email']} is already registered")
        return redirect('/auth')

    # Hash Password
    hashed_password = bcrypt.generate_password_hash(data['password'])
    data['password'] = hashed_password

    # Create user in the database
    mysql = connectToMySQL(DATABASE_NAME)
    query = 'INSERT INTO `users` (first_name, last_name, email, password) VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s)'
    mysql.query_db(query, data)

    # Redirect to login
    flash('Account Registered')
    return redirect('/auth')


if __name__ == '__main__':
    app.run(debug=True)

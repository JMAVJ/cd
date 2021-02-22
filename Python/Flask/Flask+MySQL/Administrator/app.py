from flask import Flask, render_template, session, flash, request, redirect, get_flashed_messages
from flask_bcrypt import Bcrypt
from mysqlconnection import connectToMySQL
import re


app = Flask(__name__)
bcrypt = Bcrypt(app)
app.secret_key = 'secret_key'
DATABASE = 'administrators'


# Views
@app.route('/')
def index():
    if session.get('user_id') is None:
        return redirect('/auth')

    if session.get('permissions') == 'Admin':
        return redirect('/admin')

    return redirect('/user')

    return render_template('index.html')


@app.route('/admin')
def admin():
    if session.get('user_id') is None or session.get('permissions') != 'Admin':
        session.clear()
        return redirect('/warning')

    mysql = connectToMySQL(DATABASE)
    query = 'SELECT name FROM `users` WHERE id=%(id)s'
    user_name = mysql.query_db(query, {'id': session['user_id']})
    user_name = user_name[0]['name']

    mysql = connectToMySQL(DATABASE)
    query = 'SELECT * FROM `users`'
    users = mysql.query_db(query)

    return render_template('admin.html', user_name=user_name, users=users)


@app.route('/user')
def user():
    if session.get('user_id') is None:
        return redirect('/auth')

    if session.get('permissions') == 'Admin':
        return redirect('/admin')

    return 'User'


@app.route('/warning')
def warning():
    return 'You are not allowed to access this'


@app.route('/auth')
def auth():
    if session.get('user_id') != None:
        return redirect('/')

    return render_template('auth.html')


# ===
@app.route('/remove-user/<int:id>')
def remove_user(id):
    if session.get('user_id') is None:
        return redirect('/')
    if session.get('permissions') != 'Admin':
        session.clear()
        return redirect('/warning')

    mysql = connectToMySQL(DATABASE)
    query = 'DELETE FROM users WHERE id=%(id)s'
    mysql.query_db(query, {'id': id})

    return redirect('/admin')


@app.route('/make-admin/<int:id>')
def make_admin(id):
    if session.get('user_id') is None:
        return redirect('/')
    if session.get('permissions') != 'Admin':
        session.clear()
        return redirect('/warning')

    mysql = connectToMySQL(DATABASE)
    query = 'UPDATE users SET status="Admin" WHERE id=%(id)s'
    mysql.query_db(query, {'id': id})

    return redirect('/admin')

# Authentication


@app.route('/login', methods=['POST'])
def login():
    data = {
        'email': request.form['email'],
        'password': request.form['password'],
    }

    mysql = connectToMySQL(DATABASE)
    query = 'SELECT * FROM `users` WHERE email=%(email)s'
    accounts = mysql.query_db(query, data)

    if len(accounts) < 1:
        flash('Wrong email or password')
        return redirect('/auth')

    user = accounts[0]

    if not bcrypt.check_password_hash(user['password'], data['password']):
        flash('Wrong email or password')
        return redirect('/auth')

    session['user_id'] = user['id']
    session['permissions'] = user['status']

    if user['status'] == 'Admin':
        return redirect('/admin')

    return redirect('/user')


@app.route('/register', methods=['POST'])
def register():
    data = {
        'name': request.form['name'],
        'email': request.form['email'],
    }

    error = False

    mysql = connectToMySQL(DATABASE)
    query = 'SELECT * FROM `users` WHERE email=%(email)s'
    result = mysql.query_db(query, data)

    if len(result) > 0:
        flash(f"The email {data['email']} is already registered")
        error = True

    if not data['name']:
        flash('The name can not be empty')
        error = True

    EMAIL_REGEX = re.compile(
        r'^[a-z-A-Z0-9.+_-]+@[a-z-A-Z0-9.+_-]+\.[a-zA-Z]+$')
    if not EMAIL_REGEX.match(data['email']):
        flash('The email must be valid')
        error = True

    if len(request.form['password']) < 8:
        flash('The password must be at least 8 characters long')
        error = True
    elif request.form['password'] != request.form['password_confirmation']:
        flash('The passwords do not match')
        error = True

    if error:
        return redirect('/auth')

    hashed_password = bcrypt.generate_password_hash(request.form['password'])
    data['password'] = hashed_password

    mysql = connectToMySQL(DATABASE)
    query = 'INSERT INTO `users` (name, email, password) VALUES (%(name)s, %(email)s, %(password)s)'
    user = mysql.query_db(query, data)

    mysql = connectToMySQL(DATABASE)
    query = 'SELECT status FROM `users` WHERE id=%(id)s'
    result = mysql.query_db(query, {'id': user})

    session['user_id'] = user
    session['permissions'] = result[0]['status']

    return redirect('/')


@app.route('/logout')
def logout():
    session.clear()
    return redirect('/auth')


if __name__ == '__main__':
    app.run(debug=True)

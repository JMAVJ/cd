from flask import Flask, render_template, session, redirect, flash, request
from flask_bcrypt import Bcrypt

from mysqlconnection import connectToMySQL

import re

app = Flask(__name__)
app.secret_key = 'secret_key'

bcrypt = Bcrypt(app)


# Views
@app.route('/')
def index():
    return render_template('index.html')

@app.route('/home')
def home():
    if session.get('user_id') is None:
        return redirect('/')
    return render_template('home.html')

@app.route('/log-out')
def close_session():
    session.clear()
    return redirect('/')


# API
@app.route('/auth/sign-in', methods=['POST'])
def sign_in():
    data = {
        'email': request.form['email'],
        'password': request.form['password']
    }

    mysql = connectToMySQL('register')
    query = 'SELECT * FROM `users` WHERE `email` = %(email)s;'
    accs = mysql.query_db(query, data)

    if len(accs) < 1:
        flash('The email is not registered', 'danger')
        return redirect('/')

    if not bcrypt.check_password_hash(accs[0]['password'], data['password']):
        flash('Wrong password', 'danger')
        return redirect('/')

    session['user_id'] = accs[0]['id']
    session['email'] = accs[0]['email']

    return redirect('/home')

@app.route('/auth/sign-up', methods=['POST'])
def sign_up():
    # Data
    data = {
        'email': request.form['email'],
        'password': request.form['password']
    }

    # Data Validation
    # Check if email is valid
    EMAIL_REGEX = re.compile(r'^[a-z-A-Z0-9.+_-]+@[a-z-A-Z0-9.+_-]+\.[a-zA-Z]+$')
    if not EMAIL_REGEX.match(data['email']):
        flash('The email is not valid', 'warning')
        return redirect('/')

    # Check if email is already registered
    mysql = connectToMySQL('register')
    accs = mysql.query_db('SELECT * FROM `users` WHERE `email` = %(email)s', data)
    if len(accs) > 0:
        flash('Email already in use', 'warning')
        return redirect('/')

    # Check password length
    if len(data['password']) < 8:
        flash('The password must be at least 8 characters long', 'warning')
        return redirect ('/')

    # Check if both passwords are equal
    if request.form['password_confirmation'] != data['password']:
        flash('The passwords do not match', 'warning')
        return redirect('/')
    
    #Password Hashing
    password = bcrypt.generate_password_hash(data['password'])
    data['password'] = password

    # Execute Query
    mysql = connectToMySQL('register')
    query = 'INSERT INTO users (email, password) VALUES (%(email)s, %(password)s);'
    mysql.query_db(query, data)
    
    flash('Account Registered', 'success')
    return redirect('/')


if __name__ == '__main__':
    app.run(debug=True)
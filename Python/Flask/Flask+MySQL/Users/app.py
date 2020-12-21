from flask import Flask, redirect, render_template, request
from mysqlconnection import *

app = Flask(__name__)


# Views
@app.route('/')
def index():
    return redirect('/users')

@app.route('/users')
def users():
    mysql = connectToMySQL('crud-users')
    query = 'SELECT * FROM users;'
    users = mysql.query_db(query)
    return render_template('users.html', users=users)

@app.route('/user/<int:id>')
def get_user(id):
    data = {
        'id': id
    }

    mysql = connectToMySQL('crud-users')
    query = 'SELECT * FROM users WHERE id = %(id)s;'
    user = mysql.query_db(query, data)

    return render_template('user.html', user=user[0])

@app.route('/users/new')
def new_user():
    return render_template('add_user.html')

@app.route('/users/<int:id>/edit')
def edit_user(id):
    data = {
        'id': id
    }
    mysql = connectToMySQL('crud-users')
    query = 'SELECT * FROM users WHERE id = %(id)s;'
    user = mysql.query_db(query, data)
    return render_template('edit_user.html', user=user[0]) 

# API
@app.route('/users/create', methods=['POST'])
def add_user():
    mysql = connectToMySQL('crud-users')
    data = {
        'first_name': request.form['first_name'],
        'last_name': request.form['last_name'],
        'email': request.form['email'],
    }
    query = 'INSERT INTO users (first_name, last_name, email) VALUES (%(first_name)s, %(last_name)s, %(email)s)'
    mysql.query_db(query, data)
    return redirect('/users')

@app.route('/users/<int:id>/update', methods=['POST'])
def update_user(id):
    data = {
        'id': id,
        'first_name': request.form['first_name'],
        'last_name': request.form['last_name'],
        'email': request.form['email']
    }
    mysql = connectToMySQL('crud-users')
    query = 'UPDATE users SET first_name = %(first_name)s, last_name = %(last_name)s, email = %(email)s WHERE id = %(id)s;'
    mysql.query_db(query, data)
    return redirect(f'/user/{id}')

@app.route('/users/<int:id>/destroy')
def delete_user(id):
    data = {
        'id': id
    }
    query = 'DELETE FROM users WHERE id = %(id)s'
    mysql = connectToMySQL('crud-users')
    mysql.query_db(query, data)
    return redirect('/users')


if __name__ == '__main__':
    app.run(debug=True)
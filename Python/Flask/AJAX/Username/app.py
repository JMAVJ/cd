from flask import Flask, render_template
from mysqlconnection import *

app = Flask(__name__)
DATABASE = 'basic_username'


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/username/<username>')
def username(username):
    mysql = connectToMySQL(DATABASE)
    query = f'SELECT * FROM `users` WHERE username=%(username)s'
    data = {
        'username': username,
    }
    result = mysql.query_db(query, data)
    return {
        'exists': False if not result else True,
    }
    # return render_template('partials/username.html', exists=False if not result else True)


if __name__ == '__main__':
    app.run(debug=True)

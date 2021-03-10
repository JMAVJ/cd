from flask import Flask, render_template, redirect, request
from mysqlconnection import *

app = Flask(__name__)
DATABASE = 'languages'


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/search', methods=['POST'])
def search():
    mysql = connectToMySQL(DATABASE)
    query = 'SELECT * FROM `languages` WHERE `name` LIKE %%(name)s;'
    data = {
        'name': request.form['search'] + '%',
    }
    result = mysql.query_db(query, data)
    return {
        'data': list(result),
    }


if __name__ == '__main__':
    app.run(debug=True)

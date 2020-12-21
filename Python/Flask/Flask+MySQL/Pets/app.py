from flask import Flask, render_template, redirect, request
from mysqlconnection import *


app = Flask(__name__)

# Views
@app.route('/')
def index():
    mysql = connectToMySQL('pets')
    pets = mysql.query_db('SELECT * FROM `pets`;')
    return render_template('index.html', pets=pets)


# API
@app.route('/api/add-pet', methods=['POST'])
def add_pet():
    data = {
        'name': request.form['name'],
        'type': request.form['type']
    }
    mysql = connectToMySQL('pets')
    query = 'INSERT INTO pets (name, type) VALUES (%(name)s, %(type)s)'
    mysql.query_db(query, data)
    return redirect('/')


if __name__ == '__main__':
    app.run(debug=True)
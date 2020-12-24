from flask import Flask, render_template, request, redirect
from mysqlconnection import *

app = Flask(__name__)

# Views
@app.route('/')
def index():
    return render_template('index.html')

@app.route('/user/<int:id>')
def user(id):
    mysql = connectToMySQL('form')
    data = {
        'id': id
    }
    query = 'SELECT * FROM form WHERE id = %(id)s'
    result = mysql.query_db(query, data)
    print(result)
    return render_template('user.html', data=result[0])


# API
@app.route('/api/send', methods=['POST'])
def send_form():
    mysql = connectToMySQL('form')
    data = {
        'name': request.form['name'],
        'location': request.form['location'],
        'language': request.form['language'],
        'comment': request.form['comment'],
    }
    query = 'INSERT INTO `form` (name, location, language, comment) VALUES (%(name)s, %(location)s, %(language)s, %(comment)s)'
    id = mysql.query_db(query, data)
    return redirect(f'/user/{id}')

if __name__ == '__main__':
    app.run(debug=True)
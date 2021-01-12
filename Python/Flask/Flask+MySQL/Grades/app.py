from flask import Flask, render_template, redirect, request
import pymysql.cursors
from MySQLConnection import *

app = Flask(__name__)


@app.route('/')
def index():
    query = 'SELECT * FROM `students`;'
    mysql = connectToMySQL()
    result = mysql.query_db(query)
    return render_template('index.html', students=result)


@app.route('/student/<int:id>')
def student(id):
    mysql = connectToMySQL()
    query = f'SELECT * FROM `students` WHERE ID=%(id)s;'
    query_data = {
        'id': id
    }
    student = mysql.query_db(query, query_data)

    mysql = connectToMySQL()
    query = f'SELECT * FROM `grades` WHERE student_id={id};'
    grades = mysql.query_db(query)
    return render_template('student.html', student=student[0], grades=grades)


@app.route('/add-grade/<int:id>', methods=['GET', 'POST'])
def add_grade(id):
    if request.method == 'GET':
        return render_template('add_grade.html', id=id)

    # If method is POST
    mysql = connectToMySQL()

    data = {
        'course': request.form['course'],
        'grade': request.form['grade'],
        'date': request.form['date'] if len(request.form['date']) > 0 else None,
        'comments': request.form['comment'] if len(request.form['comment']) > 0 else None,
        'student_id': id,
    }

    query = ' INSERT INTO `grades` (course, grade, date, comments, student_id) VALUES (%(course)s, %(grade)s, %(date)s, %(comments)s, %(student_id)s)'

    mysql.query_db(query, data)
    return redirect(f'/student/{id}')


if __name__ == '__main__':
    app.run(debug=True)

from flask import Flask, render_template
import pymysql.cursors


app = Flask(__name__)


db_connection = pymysql.connect(host='localhost',
                                user='root',
                                password='lqsym###',
                                db='customers',
                                charset='utf8mb4',
                                cursorclass=pymysql.cursors.DictCursor,
                                autocommit=True)


@app.route('/')
def index():
    with db_connection.cursor() as cursor:
        query = 'SELECT * FROM `customers`'
        cursor.execute(query)
        result = cursor.fetchall()

    return render_template('index.html', customers=result)


if __name__ == '__main__':
    app.run(debug=True)

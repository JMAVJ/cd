from flask import Flask, render_template, session, request
from random import randint

app = Flask(__name__)
app.secret_key = 'secret_key'

# @GET
# Home route
@app.route('/')
def index():
    if 'num' not in session:
        session['num'] = randint(1, 100)

    print(session['num'])

    return render_template('index.html', num=session['num'])

# @GET
# Route to check the player's guess
@app.route('/num/<int:guess>', methods=['POST'])
def check_num(guess):
    guess = int(request.form['guess'])
    num = session['num']
    if num < guess:
        return render_template('high.html', num=num)
    elif num > guess:
        return render_template('low.html', num=num)

    session.clear()
    return render_template('success.html', num=num)


if __name__ == '__main__':
    app.run(debug=True)
from flask import Flask, request, session, render_template, redirect
from random import randint

app = Flask(__name__)
app.secret_key = 'secret_key'


@app.route('/')
def index():
    if 'gold' not in session:
        session['gold'] = 0

    if 'activity' not in session:
        session['activity'] = []

    print(session['gold'])

    return render_template('index.html', gold=session['gold'], activity=session['activity'])

@app.route('/find', methods=['POST'])
def find():
    place = request.form['place']
    if place == 'farm':
        if randint(1, 10) <= 3:
            success = False
            profit = -5
        else:
            success = True
            profit = 10
    elif place == 'cave':
        if randint(1, 10) <= 2:
            success = False
            profit = -2
        else:
            success = True
            profit = 10
    elif place == 'house':
        if randint(1, 10) <= 1:
            success = False
            profit = -2
        else:
            success = True
            profit = 5
    elif place == 'casino':
        if randint(1, 10) <= 9:
            success = False
            profit = -200
        else:
            success = True
            profit = 1000

    session['gold'] += profit
    session['activity'].insert(0, {
        'success': success,
        'profit': profit,
        'place': place
    })
    return redirect('/')

@app.route('/reset')
def clear_session():
    session.clear()
    return redirect('/')


if __name__ == '__main__':
    app.run(debug=True)
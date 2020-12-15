from flask import Flask, render_template, session, redirect

app = Flask(__name__)
app.secret_key = 'secret_key'


@app.route('/')
def index():
    if 'counter' not in session:
        session['counter'] = 1
    else:
        session['counter'] += 1

    return render_template('index.html', counter=session['counter'])

@app.route('/clearsession')
def clear_session():
    session.clear()
    return redirect('/')

@app.route('/addtwo')
def add_two():
    session['counter'] += 2
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)
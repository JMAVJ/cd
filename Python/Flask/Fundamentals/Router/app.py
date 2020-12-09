from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/dojo')
def dojo():
    return 'Dojo!'

@app.route('/say/<text>')
def say(text):
    return f'Hello {text}!'

@app.route('/repeat/<int:times>/<value>')
def repeat(times, value):
    ls = []
    for _ in range(0, int(times)):
        ls.append(value)
    return str(' '.join(ls))

@app.errorhandler(404)
def route_not_found(error):
    return f'Sorry, no reponse <br> <br> error: {error}'

app.run()
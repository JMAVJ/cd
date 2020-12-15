from flask import Flask, render_template, request, redirect
from datetime import date

app = Flask(__name__)  

@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    form = request.form
    total_fruits = int(form['strawberry']) + int(form['raspberry']) + int(form['apple']) 
    today = date.today()
    today = today.strftime('%d/%m/%Y')
    return render_template("checkout.html", data=request.form, total_fruits = total_fruits, date=today)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")


if __name__=="__main__":   
    app.run(debug=True)    
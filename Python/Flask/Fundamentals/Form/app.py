from flask import Flask, render_template, request

app = Flask(__name__)

# @GET
# Index route that returns the main page with the form
@app.route('/')
def index():
    return render_template('index.html')

# @POST
# Post route to process the form data
@app.route('/register', methods=['POST'])
def register():
    return render_template('register.html', data=request.form)


if __name__ == '__main__':
    app.run(debug=True)
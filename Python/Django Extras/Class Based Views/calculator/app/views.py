from django.shortcuts import render
from django.views.generic import View
from django.core.exceptions import ImproperlyConfigured


class Main(object):
    template = ''
    favorite_number = 0
    least_favorite_number = 0
    context = None

    def get_template(self):
        if self.template == '':
            raise ImproperlyConfigured('Template not defined')
        return self.template

    def get(self, request):
        return render(request, self.get_template(), self.context)

    def add(num1, num2):
        return num1+num2

    def subtract(num1, num2):
        return num1-num2

    def multiply(num1, num2):
        return num1*num2

    def divide(num1, num2):
        return num1//num2


class Calculator(Main, View):
    template = 'index.html'
    favorite_number = 22
    least_favorite_number = 1
    context = {
        'num': favorite_number,
        'add': Main.add(favorite_number, least_favorite_number),
        'subtract': Main.subtract(favorite_number, least_favorite_number),
        'multiply': Main.multiply(favorite_number, least_favorite_number),
        'divide': Main.divide(favorite_number, least_favorite_number),
    }

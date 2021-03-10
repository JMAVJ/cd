from django.shortcuts import render, HttpResponse, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages

# Create your views here.


def index(request):
    if not request.user.is_authenticated:
        return redirect('/login')

    return render(request, 'index.html')


def auth(request):
    if request.user.is_authenticated:
        return redirect('/')

    return render(request, 'auth.html')

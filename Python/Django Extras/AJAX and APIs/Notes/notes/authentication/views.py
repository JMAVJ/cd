from django.shortcuts import render, HttpResponse, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages
import re

# Create your views here.


def auth(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    user = authenticate(
        username=request.POST['username'],
        password=request.POST['password']
    )

    if user == None:
        messages.error(request, 'Wrong email or password')
        return redirect('/login')

    login(request, user)
    return redirect('/')


def register(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    EMAIL_REGEX = re.compile(
        r'^[a-z-A-Z0-9.+_-]+@[a-z-A-Z0-9.+_-]+\.[a-zA-Z]+$')

    if not EMAIL_REGEX.match(request.POST['email']):
        messages.error(
            request, 'The email must be valid'
        )
        return redirect('/login')

    if len(request.POST['password']) < 8:
        messages.error(
            request, 'The password must be at least 8 characters long')
        return redirect('/login')

    if User.objects.filter(email=request.POST['email']).exists():
        messages.error(request, 'The email is already registered')
        return redirect('/login')

    user = User.objects.create_user(
        username=request.POST['username'],
        email=request.POST['email'],
        password=request.POST['password'])

    return redirect('/')


def end_session(request):
    logout(request)
    return redirect('/')

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
        username=request.POST['email'],
        password=request.POST['password']
    )

    if user == None:
        messages.error(request, 'Wrong email or password')
        return redirect('/signin')

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
        return redirect('/register')

    if len(request.POST['first_name']) < 3 or len(request.POST['last_name']) < 3:
        messages.error(
            request, 'The first and last name must be at least 3 characters long'
        )
        return redirect('/register')

    if len(request.POST['password']) < 8:
        messages.error(
            request, 'The password must be at least 8 characters long')
        return redirect('/register')

    if request.POST['password'] != request.POST['password_confirmation']:
        messages.error(
            request, 'The passwords do not match')
        return redirect('/register')

    if User.objects.filter(email=request.POST['email']).exists():
        messages.error(request, 'The email is already registered')
        return redirect('/register')

    user = User.objects.create_user(
        username=request.POST['email'],
        email=request.POST['email'],
        password=request.POST['password'],
        first_name=request.POST['first_name'],
        last_name=request.POST['last_name'])

    return redirect('/')


def end_session(request):
    logout(request)
    return redirect('/')


def update_password(request):
    if request.method != 'POST':
        return redirect('/signin')

    user = authenticate(
        username=request.user.email, password=request.POST['old_password'])

    if user == None:
        print('Wrong current password')
        return redirect('/users/edit')

    user.set_password(request.POST['new_password'])
    user.save()
    logout(request)
    return redirect('/signin')

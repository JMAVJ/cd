from django.shortcuts import render, HttpResponse, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages
import re


def auth(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    user = User.objects.get(email=request.POST['email'])

    if user == None:
        messages.error(request, 'Wrong email or password')
        return redirect('/')

    user = authenticate(
        username=user.username,
        password=request.POST['password']
    )

    if user == None:
        messages.error(request, 'Wrong email or password')
        return redirect('/')

    login(request, user)
    return redirect('/')


def register(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    error = False

    EMAIL_REGEX = re.compile(
        r'^[a-z-A-Z0-9.+_-]+@[a-z-A-Z0-9.+_-]+\.[a-zA-Z]+$')

    if not EMAIL_REGEX.match(request.POST['email']):
        messages.error(
            request, 'The email must be valid'
        )
        error = True

    if len(request.POST['name']) < 3:
        messages.error(
            request, 'The first name must be at least 3 characters long'
        )
        error = True

    if len(request.POST['password']) < 8:
        messages.error(
            request, 'The password must be at least 8 characters long')
        error = True

    if request.POST['password'] != request.POST['password_confirmation']:
        messages.error(
            request, 'The passwords do not match')
        error = True

    if User.objects.filter(email=request.POST['email']).exists():
        messages.error(request, 'The email is already registered')
        error = True

    if error:
        return redirect('/')

    user = User.objects.create_user(
        username=request.POST['username'],
        email=request.POST['email'],
        password=request.POST['password'],
        first_name=request.POST['name'])

    return redirect('/')


def end_session(request):
    logout(request)
    return redirect('/')

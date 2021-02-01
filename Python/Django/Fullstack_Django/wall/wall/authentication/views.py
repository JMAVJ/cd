from django.shortcuts import render, HttpResponse, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages

# Create your views here.


def auth(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    if request.user.is_authenticated:
        return redirect('/home')

    user = authenticate(
        username=request.POST['username'],
        password=request.POST['password']
    )

    if user == None:
        messages.error(request, 'Wrong user or password')
        return redirect('/login')

    login(request, user)
    return redirect('/')


def register(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    if len(request.POST['username']) < 3:
        messages.error(
            request, 'The username must be at least 3 characters long')
        return redirect('/register')

    if len(request.POST['password']) < 8:
        messages.error(
            request, 'The password must be at least 8 characters long')
        return redirect('/register')

    if request.POST['password'] != request.POST['confirm-password']:
        messages.error(
            request, 'The passwords do not match')
        return redirect('/register')

    if User.objects.filter(username=request.POST['username']).exists():
        messages.error(request, 'The username is already registered')
        return redirect('/register')

    user = User.objects.create_user(
        username=request.POST['username'], password=request.POST['password'])

    return redirect('/login')


def end_session(request):
    logout(request)
    return redirect('/')

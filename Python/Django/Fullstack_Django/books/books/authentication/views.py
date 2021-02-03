from django.shortcuts import render, HttpResponse, redirect
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User
from django.contrib import messages

# Create your views here.


def auth(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    if request.user.is_authenticated:
        return redirect('/')

    print(request.POST['email'], request.POST['password'])

    user = authenticate(
        username=request.POST['email'], password=request.POST['password'])

    if user == None:
        messages.error(request, "Wrong user or password")
        return redirect('/login')

    login(request, user)
    return redirect('/')


def register(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    if len(request.POST['first_name']) < 2:
        messages.error(
            request, "The first and last name must be at least 2 characters long.")

    if len(request.POST['last_name']) < 2:
        messages.error(
            request, "The first and last name must be at least 2 characters long.")

    if len(request.POST['email']) < 3:
        messages.error(request, "You must provide a valid email")
        return redirect('/login')

    if len(request.POST['password']) < 8:
        messages.error(
            request, "The password must be at leas 8 characters long")
        return redirect('/login')

    if request.POST['password'] != request.POST['password_confirmation']:
        messages.error(request, "The passwords do not match")
        return redirect('/login')

    user = User.objects.create_user(first_name=request.POST['first_name'], last_name=request.POST['last_name'],
                                    password=request.POST['password'], email=request.POST['email'], username=request.POST['email'])

    return redirect('/login')

    return


def end_session(request):

    logout(request)

    return redirect('/login')

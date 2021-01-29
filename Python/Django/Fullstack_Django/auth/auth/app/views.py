from django.shortcuts import render, HttpResponse, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages
from .models import Profile

# Create your views here.


def index(request):
    if request.user.is_authenticated:
        return render(request, 'index.html')
    else:
        return redirect('/sign-in')


def sign_up(request):
    if request.method == 'GET':
        return render(request, 'sign_up.html')

    if request.method == 'POST':
        if len(request.POST['email']) == 0:
            messages.error(request, 'The email can not be empty',
                           'alert alert-danger')
            return redirect('/sign-up')

        if len(request.POST['password']) < 3:
            messages.error(
                request, 'The password must be at least 3 characters long', 'alert alert-danger')
            return redirect('/sign-up')

        if User.objects.filter(username=request.POST['email']).exists():
            messages.error(
                request, 'The email is already registered', 'alert alert-danger')
            return redirect('/sign-up')

        user = User.objects.create_user(username=request.POST['email'],
                                        password=request.POST['password'])

        Profile.objects.create(user=user)

        print(user)
        return redirect('/sign-in')

    return HttpResponse('Method not allowed')


def sign_in(request):
    if request.user.is_authenticated:
        return redirect('/')

    if request.method == 'GET':
        return render(request, 'sign_in.html')

    if request.method == 'POST':
        print(request.POST['email'], request.POST['password'])
        user = authenticate(
            username=request.POST['email'], password=request.POST['password'])

        if user == None:
            messages.error(request, "Wrong user or password",
                           "alert alert-danger")
            return redirect('/sign-in')

        login(request, user)
        return redirect('/')

    return HttpResponse('Method not allowed')


def sign_out(request):
    logout(request)
    return redirect('/sign-in')


def add_friend(request, id):
    if request.method == 'POST':
        return HttpResponse(f'Agregar Amigo {id}')

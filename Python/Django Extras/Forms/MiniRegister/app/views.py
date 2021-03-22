from django.shortcuts import render, redirect, HttpResponse
from .forms import RegisterForm, LoginForm
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required
from django.contrib.auth import logout, login, authenticate
from django.contrib import messages
import json


def auth(request):
    if request.user.is_authenticated:
        return redirect('/home')

    context = {
        'register_form': RegisterForm,
        'login_form': LoginForm
    }

    return render(request, 'auth.html', context)


def register(request):
    if request.method != 'POST':
        return HttpResponse('Method not Allowed')

    form = RegisterForm(request.POST)

    if not form.is_valid():
        print(dict(form.errors.as_data()))
        return redirect('/')

    user = User.objects.create(
        first_name=request.POST['first_name'],
        last_name=request.POST['last_name'],
        username=request.POST['email'],
        password=request.POST['password'],
    )

    login(request, user)

    return redirect('/home')


def log_in(request):
    if request.method != 'POST':
        return HttpResponse('Method not Allowed')

    user = authenticate(
        username=request.POST['email'], password=request.POST['password'])

    if user == None:
        return redirect('/')

    login(request, user)

    return redirect('/home')


@login_required(login_url='/')
def home(request):
    return render(request, 'home.html')


@login_required(login_url='/')
def log_out(request):
    logout(request)
    return redirect('/')

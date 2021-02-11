from django.shortcuts import render, HttpResponse, redirect
from django.contrib.auth.models import User

# Create your views here.


def index(request):
    if request.user.is_authenticated:
        return redirect('/dashboard')

    return render(request, 'index.html')


def register(request):
    return render(request, 'register.html')


def signin(request):
    return render(request, 'signin.html')


def dashboard(request):
    if not request.user.is_authenticated:
        return redirect('/signin')
    context = {
        'users': User.objects.all()
    }
    return render(request, 'dashboard.html', context)


def show_user(request, id):
    context = {
        'user': User.objects.get(id=id),
    }
    return render(request, 'user.html', context)


def profile(request):
    if not request.user.is_authenticated:
        return redirect('/signin')

    context = {
        'user': User.objects.get(id=request.user.id),
    }

    return render(request, 'profile.html', context)

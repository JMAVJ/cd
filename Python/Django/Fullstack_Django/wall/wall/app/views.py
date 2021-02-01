from django.shortcuts import render, HttpResponse, redirect
from .models import *

# Create your views here.


def index(request):
    if request.user.is_authenticated:
        return redirect('/home')

    return render(request, 'index.html')


def home(request):
    if not request.user.is_authenticated:
        return redirect('/login')

    context = {
        'posts': Post.objects.all().order_by('-id'),
    }

    return render(request, 'app.html', context)


def login(request):
    if request.user.is_authenticated:
        return redirect('/home')
    return render(request, 'login.html')


def register(request):
    if request.user.is_authenticated:
        return redirect('/home')
    return render(request, 'register.html')


def post(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    if not request.user.is_authenticated:
        return redirect('/login')

    if len(request.POST['post']) < 1:
        messages.error(request, 'You can not make an empty post')
        return redirect('/home')

    Post.objects.create(content=request.POST['post'], user=request.user)

    return redirect('/')

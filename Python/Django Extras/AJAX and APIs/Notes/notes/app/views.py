from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from .models import *


# Create your views here.
@login_required(login_url='/login')
def index(request):
    print(request.user.notes)
    context = {
        'messages': request.user.notes,
    }
    return render(request, 'home.html', context)


def create_note(request):
    note = Note.objects.create(
        note=request.POST['note'],
        author=request.user
    )
    return redirect('/')


def login(request):
    return render(request, 'auth.html')

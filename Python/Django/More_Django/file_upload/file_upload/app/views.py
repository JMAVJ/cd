from django.shortcuts import render, HttpResponse, redirect
from .models import *

# Create your views here.


def index(request):
    context = {
        'files': Document.objects.all()
    }
    return render(request, 'index.html', context)


def upload_file(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    file = Document.objects.create(file=request.FILES['file'])
    return redirect('/')

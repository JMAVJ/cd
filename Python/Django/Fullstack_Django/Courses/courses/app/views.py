from django.shortcuts import render, HttpResponse, redirect
from django.contrib import messages
from .models import *


# Create your views here.


def index(request):
    context = {
        'courses': Course.objects.all(),
    }
    return render(request, 'index.html', context)


def add_course(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    errors = Course.objects.validator(request.POST)

    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/')

    course = Course.objects.create(name=request.POST['name'])
    description = Description.objects.create(
        content=request.POST['description'], course=course)

    return redirect('/')


def delete_course(request, id):
    if request.method == 'GET':
        context = {
            'course': Course.objects.get(id=id),
        }
        return render(request, 'delete_course.html', context)

    Course.objects.get(id=request.POST['id']).delete()
    return redirect('/')

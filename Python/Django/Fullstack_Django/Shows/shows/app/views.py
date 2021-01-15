from django.shortcuts import render, HttpResponse, redirect
from .models import *

# Create your views here.


def index(request):
    return redirect('/shows')


def shows(request):
    context = {
        'shows': Show.objects.all(),
    }
    return render(request, 'shows.html', context)


def show(request, id):
    context = {
        'show': Show.objects.get(id=id)
    }
    return render(request, 'show.html', context)


def new_show(request):
    if request.method == 'GET':
        return render(request, 'new_show.html')

    if request.method == 'POST':
        show = Show.objects.create(
            title=request.POST['title'],
            network=request.POST['network'],
            release_date=request.POST['date'],
            description=request.POST['description']
        )
        return redirect(f'/shows/{show.id}')

    return HttpResponse('Method Not Allowed')


def edit_show(request, id):
    if request.method == 'GET':
        context = {
            'show': Show.objects.get(id=id)
        }
        return render(request, 'edit_show.html', context)

    if request.method == 'POST':
        show = Show.objects.get(id=id)
        show.title = request.POST['title']
        show.network = request.POST['network']
        show.description = request.POST['description']
        show.save()
        return redirect(f'/shows/{id}')

    return HttpResponse('Method Not Allowed')


def delete_show(request, id):
    show = Show.objects.get(id=id)
    show.delete()
    return redirect('/')

from django.shortcuts import render
from django.http import JsonResponse, HttpResponse
from .models import *


# Create your views here.
def index(request):
    return render(request, 'index.html')


def get_notes(request):
    notes = list(Note.objects.values())
    return JsonResponse(notes, safe=False)


def create_note(request):
    note = Note.objects.create(
        title=request.POST['title'], description=request.POST['description'])
    return HttpResponse(status=200)


def delete_note(request):
    Note.objects.get(id=request.POST['note_id']).delete()
    return HttpResponse(status=200)


def update_description(request):
    Note.objects.get(id=request.POST['id']).update(
        description=request.POST['description'])

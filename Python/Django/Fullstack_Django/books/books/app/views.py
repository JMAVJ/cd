from django.shortcuts import render, redirect, HttpResponse
from django.contrib import messages
from .models import *

# Create your views here.


def index(request):
    if not request.user.is_authenticated:
        return redirect('/login')

    context = {
        'books': Book.objects.all(),
        'favourite_books': User.objects.get(id=request.user.id).favourite_books.all(),
    }

    print(context['favourite_books'])

    return render(request, 'index.html', context)


def login(request):
    return render(request, 'auth.html')


def add_book(request):

    if len(request.POST['title']) < 1:
        messages.error(request, "The title can not be empty")
        return redirect('/')

    book = Book.objects.create(
        title=request.POST['title'], desc=request.POST['description'], uploaded_by=request.user)

    book.liked_by.add(request.user)

    return redirect('/')


def add_favourite(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    book = Book.objects.get(id=request.POST['id'])
    request.user.favourite_books.add(book)
    return redirect('/')


def remove_favourite(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    book = Book.objects.get(id=request.POST['id'])
    request.user.favourite_books.remove(book)
    return redirect('/')


def book(request, id):
    if not request.user.is_authenticated:
        return redirect('/login')

    context = {
        "book": Book.objects.get(id=id)
    }

    if context['book'].uploaded_by == request.user:
        return render(request, 'book_owner.html', context)

    return render(request, 'book.html', context)


def delete_book(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    book = Book.objects.get(id=request.POST['id'])
    book.delete()
    return redirect('/')


def update_book(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    book = Book.objects.get(id=request.POST['id'])
    book.title = request.POST['title']
    book.desc = request.POST['desc']
    book.save()
    return redirect('/')

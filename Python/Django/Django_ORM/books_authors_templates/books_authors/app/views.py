from django.shortcuts import render, HttpResponse, redirect
from .models import *
# Create your views here.


def index(request):
    context = {
        'books': Book.objects.all(),
    }
    return render(request, 'index.html', context)


def authors(request):
    context = {
        'authors': Author.objects.all(),
    }
    return render(request, 'authors.html', context)


def book(request, id):
    book = Book.objects.get(id=id)
    context = {
        'book': book,
        'book_authors': book.authors.all(),
        'authors': Author.objects.all(),
    }

    return render(request, 'book.html', context)


def add_book(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    book = Book.objects.create(
        title=request.POST['title'], desc=request.POST['desc'])

    return redirect(f'/book/{book.id}')


def add_author(request):
    if request.method != 'POST':
        return redirect('/')

    author = Author.objects.create(
        first_name=request.POST['first_name'], last_name=request.POST['last_name'])

    return redirect('/authors')


def add_author_to_book(request, id):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    if request.POST['author'] == 'none':
        return redirect('/')

    print(request.POST['author'])

    book = Book.objects.get(id=id)
    author = Author.objects.get(id=request.POST['author'])

    book.authors.add(author)

    return redirect(f'/book/{book.id}')

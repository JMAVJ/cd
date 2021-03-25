from django.shortcuts import render, redirect, HttpResponse
from django.contrib.auth.decorators import login_required
from .models import *


def index(request):
    return redirect('/books' if request.user.is_authenticated else '/login')


def auth(request):
    if request.user.is_authenticated:
        return redirect('/books')


@login_required(login_url='/login')
def books(request):
    context = {
        'reviews': Review.objects.all(),
    }
    return render(request, 'index.html', context)


@login_required(login_url='/login')
def book(request, id):
    context = {
        'book': Book.objects.get(id=id),
    }
    return render(request, 'book.html', context)


@login_required(login_url='/login')
def add_book(request):
    if request.method == 'GET':
        context = {
            'authors': Author.objects.all(),
        }
        return render(request, 'add_book.html', context)

    if request.method == 'POST':
        if request.POST['author'] == 'none' and len(request.POST['new_author']) > 0:
            author = Author.objects.create(name=request.POST['new_author'])

        if request.POST['author'] != 'none':
            author = Author.objects.get(id=request.POST['author'])

        book = Book.objects.create(
            title=request.POST['title'], author=Author.objects.get(id=author.id))

        Review.objects.create(
            user=request.user, comment=request.POST['comment'], book=book, rating=request.POST['rating'])

        return redirect('/books')

    return HttpResponse('Method not allowed')


@login_required(login_url='/login')
def add_review(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    book = Book.objects.get(id=request.POST['id'])
    Review.objects.create(book=book, user=request.user,
                          rating=request.POST['rating'], comment=request.POST['comment'])

    return redirect(f'/book/{book.id}')

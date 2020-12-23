from django.shortcuts import render, HttpResponse, redirect, render

# Create your views here.
def index(request):
    return HttpResponse('Blog List')

def new(request):
    return HttpResponse('Form to create a new blog')

def create(request):
    return redirect('/')

def show(request, num):
    return HttpResponse(f'Show blog number {num}')

def edit(request, blog):
    return HttpResponse(f'Edit blog number {blog}')

def destroy(request, blog):
    return redirect('/')

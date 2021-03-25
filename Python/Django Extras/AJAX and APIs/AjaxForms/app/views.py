from django.shortcuts import render, HttpResponse
from django.http import JsonResponse
from django.contrib.auth.models import User
from django.db.models import Q


def index(request):
    context = {
        'users': User.objects.all().values('id', 'first_name', 'last_name', 'email', 'date_joined'),
    }
    return render(request, 'index.html', context)


def search_name(request):
    data = list(User.objects.filter(Q(first_name__contains=request.GET['name']) | Q(last_name__contains=request.GET['name'])).values(
        'id', 'first_name', 'last_name', 'email', 'date_joined'))
    return JsonResponse(data, safe=False)


def search_date(request):
    data = list(User.objects.filter(date_joined__range=(request.GET['date_from'], request.GET['date_to'])).values(
        'id', 'first_name', 'last_name', 'email', 'date_joined'))
    return JsonResponse(data, safe=False)

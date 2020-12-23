from django.shortcuts import render, HttpResponse
from time import strftime, localtime

# Create your views here.
def index(request):
    context = {
        'date': strftime('%b. %d %Y %H:%M', localtime()),
    }
    return render(request, 'index.html', context)

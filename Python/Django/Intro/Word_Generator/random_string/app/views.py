from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string

# Create your views here.
def index(request):
    if 'counter' not in request.session:
        request.session['counter'] = 0
    request.session['counter'] += 1
    context = {
        'string': get_random_string(14),
        'counter': request.session['counter']
    }
    return render(request, 'index.html', context)

def reset(request):
    del request.session['counter']
    return redirect('/random_word')

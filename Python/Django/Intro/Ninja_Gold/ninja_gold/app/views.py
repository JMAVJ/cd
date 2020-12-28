from django.shortcuts import render, HttpResponse, redirect
from random import randint

# Create your views here.
def index(request):
    if 'gold' not in request.session:
        request.session['gold'] = 0

    if 'activity' not in request.session:
        request.session['activity'] = []
    context = {
        'activity': request.session['activity'],
        'gold': request.session['gold']
    }
    return render(request, 'index.html', context)

def process_money(request):
    place = request.POST['place']
    if place == 'farm':
        if randint(1, 10) <= 3:
            success = False
            profit = -5
        else:
            success = True
            profit = 10
    elif place == 'cave':
        if randint(1, 10) <= 2:
            success = False
            profit = -2
        else:
            success = True
            profit = 10
    elif place == 'house':
        if randint(1, 10) <= 1:
            success = False
            profit = -2
        else:
            success = True
            profit = 5
    elif place == 'casino':
        if randint(1, 10) <= 9:
            success = False
            profit = -200
        else:
            success = True
            profit = 1000

    request.session['gold'] += profit
    request.session['activity'].insert(0, {
        'success': success,
        'profit': profit,
        'place': place
    })
    return redirect('/')

def reset_session(request):
    keys = list(request.session.keys())
    for key in keys:
        del request.session[key]
    return redirect('/')
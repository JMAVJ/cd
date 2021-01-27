from django.shortcuts import render, redirect, HttpResponse
from .models import League, Team, Player
from django.db.models import Q

from . import team_maker


def index(request):
    context = {
        "baseball_leagues": League.objects.filter(sport='Baseball'),
        "women_leagues": League.objects.filter(name__contains='Womens'),
        "hockey_leagues": League.objects.filter(sport__contains='Hockey'),
        "not_football_leagues": League.objects.exclude(sport='Football'),
        "conference_leagues": League.objects.filter(name__contains='Conference'),
        "transamerican_leagues": League.objects.filter(name__contains='Transamerican'),
        "dallas_teams": Team.objects.filter(location='Dallas'),
        "raptors_teams": Team.objects.filter(team_name='Raptors'),
        "city_teams": Team.objects.filter(location__contains='City'),
        "t_teams": Team.objects.filter(team_name__startswith='T'),
        "location_sorted_teams": Team.objects.order_by('location'),
        "desc_name_sorted_teams": Team.objects.order_by('-team_name'),
        "cooper_lastname_players": Player.objects.filter(last_name='Cooper'),
        "joshua_named_players": Player.objects.filter(first_name='Joshua'),
        "cooper_lastname_players_except_joshua": Player.objects.filter(last_name='Cooper').exclude(first_name='Joshua'),
        "alexander_or_wyatt_players": Player.objects.filter(Q(first_name='Alexander') | Q(first_name='Wyatt'))
    }
    return render(request, "leagues/index.html", context)


def make_data(request):
    team_maker.gen_leagues(10)
    team_maker.gen_teams(50)
    team_maker.gen_players(200)

    return HttpResponse('Done')
    # return redirect("index")

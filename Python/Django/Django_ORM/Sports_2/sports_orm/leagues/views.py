from django.shortcuts import render, redirect, HttpResponse
from .models import League, Team, Player
from django.db.models import Q

from . import team_maker


def index(request):
    context = {
        'query_1': Team.objects.filter(league=League.objects.filter(name="Pacific Soccer Federation")),
        'query_2': Team.objects.get(team_name="Boston Penguins", location="California").curr_players.all(),
        'query_3': League.objects.get(name="International Collegiate Baseball Conference").teams.values('curr_players'),
        'query_4': Player.objects.filter(last_name="López", curr_team__league__name="Amateur American Football Conference"),
        'query_5': Team.objects.filter(league__name__contains="Football"),
        'query_6': Team.objects.filter(curr_players__first_name="Sophia"),
        'query_7': League.objects.filter(teams__curr_players__first_name="Sophia"),
        'query_8': Player.objects.filter(last_name="Flores").exclude(curr_team_id__league__name="Washington Roughriders"),
        'query_9': Player.objects.get(first_name="Samuel",  last_name="Evans").all_teams,
        'query_10': Player.objects.filter(first_name="Samuel").filter(last_name="Barnes")[0].all_teams.values(),
        'query_11': Player.objects.filter(all_teams__team_name="Vikings", all_teams__location="Wichita").exclude(curr_team__team_name="Vikings", curr_team__location="Wichita"),
    }
    return render(request, "leagues/index.html", context)


def make_data(request):
    team_maker.gen_leagues(10)
    # team_maker.gen_teams(50)
    # team_maker.gen_players(200)

    return HttpResponse('Done')
    # return redirect("index")

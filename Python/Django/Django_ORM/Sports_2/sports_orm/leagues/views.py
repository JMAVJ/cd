from django.shortcuts import render, redirect, HttpResponse
from .models import League, Team, Player
from django.db.models import Q

from . import team_maker


def index(request):
    print('===')
    # print(Team.objects.filter(
    #     league=League.objects.get(name='Transamerican Basketball Conference').id))
    transamerican_basketball_players = Team.objects.filter(league=League.objects.get(
        name='Transamerican Basketball Conference'))

    # transamerican_basketball_players = []

    # for team in transamerican_basketball_teams:
    #     transamerican_basketball_players.append(
    #         team.curr_players.values('first_name', 'last_name'))

    print(transamerican_basketball_players)

    context = {
        "teams_in_transamerican_football_conference": Team.objects.filter(league_id=League.objects.get(
            name='Transamerican Football Players Conference').id),
        "actual_players_in_philadelphia_showboats": Player.objects.filter(curr_team=Team.objects.get(
            team_name='Showboats', location='Philadelphia')),
        "transamerican_basketball_conference_players": transamerican_basketball_players,
    }
    return render(request, "leagues/index.html", context)


def make_data(request):
    team_maker.gen_leagues(10)
    # team_maker.gen_teams(50)
    # team_maker.gen_players(200)

    return HttpResponse('Done')
    # return redirect("index")

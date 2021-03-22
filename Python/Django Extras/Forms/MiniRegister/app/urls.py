from django.urls import path
from . import views


urlpatterns = [
    path('', views.auth),
    path('register', views.register),
    path('login', views.log_in),
    path('logout', views.log_out),
    path('home', views.home),
]

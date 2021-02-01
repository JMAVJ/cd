from django.urls import path
from . import views


urlpatterns = [
    path('', views.index),
    path('login', views.login),
    path('register', views.register),
    path('home', views.home),
    path('post', views.post),
]

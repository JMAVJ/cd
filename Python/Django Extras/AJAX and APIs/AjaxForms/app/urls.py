from django.urls import path
from . import views


urlpatterns = [
    path('', views.index),
    path('search-name', views.search_name),
    path('search-date', views.search_date),
]

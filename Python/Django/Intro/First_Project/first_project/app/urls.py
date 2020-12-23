from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('new/', views.new),
    path('create/', views.create),
    path('<int:num>/', views.show),
    path('<int:blog>/edit/', views.edit),
    path('<int:blog>/delete/', views.destroy),
] 
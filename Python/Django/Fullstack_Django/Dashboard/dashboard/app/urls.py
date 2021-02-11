from django.urls import path
from . import views


urlpatterns = [
    path('', views.index),
    path('register', views.register),
    path('signin', views.signin),
    path('dashboard', views.dashboard),
    path('users/show/<int:id>', views.show_user),
    path('users/edit', views.profile),
]

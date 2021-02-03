from django.urls import path
from . import views


urlpatterns = [
    path('', views.index),
    path('login', views.login),
    path('add-book', views.add_book),
    path('book/<int:id>', views.book),
    path('add-favourite', views.add_favourite),
    path('remove-favourite', views.remove_favourite),
    path('delete-book', views.delete_book),
    path('update-book', views.update_book),
]

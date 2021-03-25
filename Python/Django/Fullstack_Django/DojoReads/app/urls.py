from django.urls import path
from . import views


urlpatterns = [
    path('', views.index),
    path('login', views.auth),
    path('books', views.books),
    path('add-book', views.add_book),
    path('book/<int:id>', views.book),
    path('add-review', views.add_review),
]

from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('authors', views.authors),
    path('book/<int:id>', views.book),
    path('add-book', views.add_book),
    path('add-author', views.add_author),
    path('add-author-to-book/<int:id>', views.add_author_to_book),
]

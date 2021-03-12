from django.urls import path
from . import views


urlpatterns = [
    path('', views.index),
    path('get-notes', views.get_notes),
    path('create-note', views.create_note),
    path('delete-note', views.delete_note),
    path('update-description', views.update_description),
]

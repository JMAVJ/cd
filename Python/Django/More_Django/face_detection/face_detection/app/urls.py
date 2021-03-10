from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('upload-image', views.upload_image),
    path('process-image', views.process_image),
]

from django.urls import path
from .views import Calculator


urlpatterns = [
    path('', Calculator.as_view()),
]

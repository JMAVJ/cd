from django.db import models
from django.contrib.auth.models import User


class Note(models.Model):
    note = models.CharField(max_length=200)
    author = models.ForeignKey(
        User, related_name='notes', on_delete=models.CASCADE)

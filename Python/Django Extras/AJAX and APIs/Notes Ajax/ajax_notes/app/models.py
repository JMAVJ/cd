from django.db import models


class Note(models.Model):
    title = models.CharField(max_length=200)
    description = models.CharField(max_length=1000)

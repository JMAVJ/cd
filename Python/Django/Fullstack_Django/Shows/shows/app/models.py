from django.db import models

# Create your models here.


class Show(models.Model):
    title = models.CharField(max_length=64)
    network = models.CharField(max_length=64)
    release_date = models.DateField()
    description = models.TextField(max_length=500)

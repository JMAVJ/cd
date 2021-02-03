from django.db import models
from django.contrib.auth.models import User

# Create your models here.


class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.CharField(max_length=500)
    created_at = models.DateField(auto_now_add=True)
    updated_at = models.DateField(auto_now=True)
    uploaded_by = models.ForeignKey(
        User, related_name='uploaded_books', on_delete=models.CASCADE)
    liked_by = models.ManyToManyField(User, related_name='favourite_books')

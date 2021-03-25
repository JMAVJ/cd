from django.db import models
from django.contrib.auth.models import User


class Author(models.Model):
    name = models.CharField(max_length=128)


class Book(models.Model):
    title = models.CharField(max_length=128)
    author = models.ForeignKey(
        Author, related_name='books', on_delete=models.CASCADE)
    created_at = models.DateField(auto_now_add=True)


class Review(models.Model):
    user = models.ForeignKey(
        User, related_name='reviews', on_delete=models.CASCADE)
    book = models.ForeignKey(
        Book, related_name='reviews', on_delete=models.CASCADE)
    rating = models.IntegerField()
    comment = models.TextField(max_length=512)
    created_at = models.DateField(auto_now_add=True)

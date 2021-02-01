from django.db import models
from django.contrib.auth.models import User

# Create your models here.


class Post(models.Model):
    user = models.ForeignKey(User, related_name='posts',
                             on_delete=models.CASCADE)
    content = models.CharField(max_length=200)
    created_at = models.DateField(auto_now_add=True)

from django.db import models

# Create your models here.


class Image(models.Model):
    file = models.FileField(upload_to='app/documents')

from django.db import models


class Image(models.Model):
    file = models.FileField(upload_to='app/documents')


class ProcessedImage(models.Model):
    image = models.CharField(max_length=1024)

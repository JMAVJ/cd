from django.db import models

# Create your models here.


class ShowManager(models.Manager):
    def basic_validator(self, post_data):
        errors = {}

        if len(post_data['title']) < 1:
            errors['title'] = 'The title can not be empty'

        if len(post_data['network']) < 1:
            errors['network'] = 'The network can not be empty'

        if len(post_data['description']) < 1:
            errors['description'] = 'The description can not be empty'

        return errors


class Show(models.Model):
    title = models.CharField(max_length=64)
    network = models.CharField(max_length=64)
    release_date = models.DateField()
    description = models.TextField(max_length=500)
    objects = ShowManager()

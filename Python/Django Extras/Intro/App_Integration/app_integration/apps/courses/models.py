from django.db import models
from django.contrib.auth.models import User


class CourseManager(models.Manager):
    def validator(self, data):
        errors = {}

        if len(data['name']) < 5:
            errors['name'] = 'The name must be at least 5 characters long'

        if len(data['description']) < 15:
            errors['description'] = 'The description must be at least 15 characters long'

        return errors


class Course(models.Model):
    name = models.CharField(max_length=100)
    created_by = models.ForeignKey(
        User, related_name='courses', on_delete=models.CASCADE)
    created_at = models.DateField(auto_now_add=True)
    objects = CourseManager()


class Description(models.Model):
    content = models.CharField(max_length=500)
    course = models.OneToOneField(
        Course, related_name='description', on_delete=models.CASCADE)

from django import forms
from django.core.exceptions import ValidationError
from django.utils.translation import ugettext_lazy as _


# Validators
def validate_length(value):
    if len(value) < 3:
        raise ValidationError(
            _('%(value)s is not 8 characters long'),
            params={'value': value},
        )


# Forms
class RegisterForm(forms.Form):
    first_name = forms.CharField(max_length=200, validators=[validate_length])
    last_name = forms.CharField(max_length=200, validators=[validate_length])
    email = forms.EmailField()
    password = forms.CharField(max_length=200, widget=forms.PasswordInput)
    confirm_password = forms.CharField(
        max_length=200, widget=forms.PasswordInput)


class LoginForm(forms.Form):
    email = forms.EmailField()
    password = forms.CharField(max_length=200, widget=forms.PasswordInput)

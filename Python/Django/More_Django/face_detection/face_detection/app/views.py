from django.shortcuts import render, HttpResponse, redirect
from .models import Image
import cv2
import os
# Create your views here.


def index(request):
    return render(request, 'index.html')


def upload_image(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    file = Image.objects.create(file=request.FILES['file'])
    print(request.FILES['file'])
    return redirect('/')


def process_image(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    file = Image.objects.create(file=request.FILES['file'])
    classifier = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
    img = cv2.imread('people3.jpg')
    grayscale_image = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    faces_coordinates = classifier.detectMultiScale(grayscale_image)

    for (x, y, w, h) in faces_coordinates:
        cv2.rectangle(img, (x, y), (x+w, y+h), (255, 0, 0), 2)

    cv2.imwrite('output.png', img)
    return HttpResponse('Ok')

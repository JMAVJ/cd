from django.shortcuts import render, HttpResponse, redirect
from .models import Image, ProcessedImage
import cv2
import os


def index(request):
    context = {
        'images': ProcessedImage.objects.all()
    }
    return render(request, 'index.html', context)


def upload_image(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    file = Image.objects.create(file=request.FILES['file'])
    return redirect('/')


def process_image(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    file = Image.objects.create(file=request.FILES['file'])
    classifier = cv2.CascadeClassifier(
        './app/haarcascade_frontalface_default.xml')
    img = cv2.imread(str(file.file))
    grayscale_image = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    faces_coordinates = classifier.detectMultiScale(grayscale_image)

    for (x, y, w, h) in faces_coordinates:
        cv2.rectangle(img, (x, y), (x+w, y+h), (255, 0, 0), 2)

    file_dir = str(file.file).split('.')[0]
    file_extension = str(file.file).split('.')[1]

    cv2.imwrite(f'./{file_dir}-processed.{file_extension}', img)
    ProcessedImage.objects.create(
        image=f'./{file_dir}-processed.{file_extension}')
    return redirect('/')

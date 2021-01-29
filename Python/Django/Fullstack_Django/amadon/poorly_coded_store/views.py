from django.shortcuts import render, HttpResponse, redirect
from .models import Order, Product


def index(request):
    context = {
        "all_products": Product.objects.all()
    }
    return render(request, 'store/index.html', context)


def checkout(request, id):
    context = {
        'order': Order.objects.get(id=id),
    }
    return render(request, 'store/checkout.html', context)


def process_purchase(request):
    if request.method != 'POST':
        return HttpResponse('Method not allowed')

    quantity = request.POST['quantity']
    total_price = Product.objects.get(
        id=request.POST['id']).price * int(quantity)

    order = Order.objects.create(
        quantity_ordered=quantity, total_price=total_price)

    return redirect(f'/checkout/{order.id}')

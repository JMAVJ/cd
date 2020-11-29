def countdown(num):
    numbers = []
    for i in range(num, -1, -1):
        numbers.append(i)
    return numbers

print(countdown(5))
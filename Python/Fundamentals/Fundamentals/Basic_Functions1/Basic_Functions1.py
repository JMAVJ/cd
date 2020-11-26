# 1
def a():
    return 5


print('#1')
print('Prediction: ')
print('Result ', a())


# 2
def b():
    return 5


print('')
print('#2')
print('Prediction: 10')
print('Result: ', b()+b())


# 3
def c():
    return 5
    return 10


print('')
print('#3')
print('Prediction: 5')
print('Result: ', c())


# 4
def d():
    return 5
    print(10)


print('')
print('#4')
print('Prediction: 5')
print('Result: ', d())


# 5
def d():
    print(5)


x = d()
print('')
print('#4')
print('Prediction: None')
print('Result: ', x)


# 6
print('')
print('#4')


def a(b, c):
    print(b+c)


print(a(1, 2) + a(2, 3))
print('Prediction: 8, None')
print('Result: ', x)

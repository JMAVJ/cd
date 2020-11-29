def length_and_value(size, value):
    result = []
    for _ in range(0, size):
        result.append(value)
    return result


print(length_and_value(4, 7))
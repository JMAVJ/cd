def min(ls):
    if len(ls) == 0:
        return False
    ls.sort()
    return ls[0]

print(min([1,2,3]))
def max(ls):
    if len(ls) == 0:
        return False
    ls.sort()
    return ls[-1]

print(max([1,10,3]))
def sum_total(nums):
    total = 0
    for num in nums:
        total += num
    return total

def avg(nums):
    total = 0
    for num in nums:
        total += num
    return total/len(nums)

def min(ls):
    if len(ls) == 0:
        return False
    ls.sort()
    return ls[0]

def max(ls):
    if len(ls) == 0:
        return False
    ls.sort()
    return ls[-1]

def analysis(ls):
    data = {
        'total': sum_total(ls),
        'average': avg(ls),
        'min': min(ls),
        'max': max(ls),
        'length': len(ls)
    }

    return data

print(analysis([37,2,1, -9]))
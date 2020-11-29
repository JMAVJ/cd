def big(nums):
    new_list = []
    for num in nums:
        if num > 0:
            new_list.append('big')
        else:
            new_list.append(num)
    return new_list

print(big([- 1, 3, 5, -5]))
def avg(nums):
    total = 0
    for num in nums:
        total += num
    return total/len(nums)

print(avg([1, 2, 3, 4]))

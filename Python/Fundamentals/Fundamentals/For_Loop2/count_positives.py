def count_positives(nums):
    counter = 0
    for num in nums:
        if num > 0:
            counter += 1
    nums[-1] = counter
    return nums

print(count_positives([- 1,1,1,1]))

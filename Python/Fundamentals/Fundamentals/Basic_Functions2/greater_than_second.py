def greater_than_second(nums):
    if len(nums) < 2: 
        return False
    
    new_list = []
    for num in nums:
        if num > nums[1]: 
            new_list.append(num)
    
    print(len(new_list))
    return new_list

print(greater_than_second([3]))
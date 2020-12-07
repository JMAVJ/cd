x = [[5,2,3], [10,8,9]]

def switch_num(arr, num_from, num_to):
    for ls in arr:
        for i in ls:
            if i == num_from:
                x[x.index(ls)][ls.index(i)] = num_to

    return arr

print(switch_num(x, 10, 15))
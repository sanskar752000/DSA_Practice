import numpy as np

def BinarySearch(a, n, x):
    l = 1
    h = n

    while l<=h:
        mid = int((l+h)/2)
        if (a[mid] == x):
            return mid
        elif (a[mid] < x):
            l = mid + 1
        else:
            h = mid - 1
    return 0

array = [10, 20, 30, 40, 50, 60]
non_recursive_binary_search = BinarySearch(array, 6, 50)
print(non_recursive_binary_search)
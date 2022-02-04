def BinarySearch(a, l, h, x):
    if l == h:
        if a[l] == x:
            return l
        else:
            return 0
    else:
        mid = int((l + h)/2)
        if (a[mid] == x):
            return mid
        elif a[mid] < x:
            BinarySearch(a, mid+1, h, x)
        else:
            BinarySearch(a, l, mid-1, x)
    return l

array = [10, 20, 30, 40, 50, 60]
recursive_binary_search = BinarySearch(array, 0, 5, 20)
print(recursive_binary_search)
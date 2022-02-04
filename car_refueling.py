def MinRefill(x, n, L):
    #numRefills -> no. of fuel refill made in the car
    numRefills = 0

    # currentRefill -> at position we are currently standing at
    currentRefill = 0

    while currentRefill <= n:

        #lastRefill -> last position where we were present
        lastRefill = currentRefill
        while (currentRefill <= n and ((x[currentRefill + 1] - x[lastRefill])<= L)):
            currentRefill = currentRefill + 1
        if currentRefill == lastRefill:
            return 'IMPOSSIBLE'
        elif currentRefill <= n:
            numRefills = numRefills + 1
    return numRefills

x =[0, 200, 375, 550, 750, 950]

car_refuel = MinRefill(x, 5, 400)
print(car_refuel)
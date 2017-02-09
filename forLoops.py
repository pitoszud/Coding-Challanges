def solution():
    num = [5, 10, 15, 20, 25, 30, 35, 24, 12, 18, 67, 5, 83]
    numStr = ['five', 'ten', 'fifteen', 'twenty', 'twentyFive', 'thirty', 'thirtyFive']
    numInt = [5, 10, 15, 20, 25, 30, 35]

    for i in range(len(numStr)):
        print(i)  # 0,1,2,3,4,5,6

    print()

    for i in range(0, len(numStr)):
        print(i)  # 0,1,2,3,4,5,6

    print()

    for i in range(len(numStr)):
        print(numStr[i])  # five, ten, fifteen, twenty, twentyFive, thirty, thirtyFive

    print()

    for i in numStr:
        print(i)  # five, ten, fifteen, twenty, twentyFive, thirty, thirtyFive

    print()

    for i in numStr[0:]:
        print(i)  # five, ten, fifteen, twenty, twentyFive, thirty, thirtyFive

    print()

    for i in range(2,8,2): # from i2 to i8, every 2
        print(num[i]) # 15, 25, 35

    print()

    for i in range(len(num)-1, 0, -1):  # from last to second
        print(num[i])  # 83, 5, 67, 18, 12, 24, 35, 30, 25, 20, 15, 10

    print()

    for s, v in zip(numStr, numInt):  # 5: five; 10: ten ...#
        # #print(i,':', v)
        print('{0}: {1}'.format(v, s))


solution()
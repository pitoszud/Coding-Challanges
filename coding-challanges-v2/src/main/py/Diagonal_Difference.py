
def getVals():
    n = int(input().strip())
    a = []
    for a_i in range(n):
        a_t = [int(a_temp) for a_temp in input().strip().split(' ')]
        a.append(a_t)
    return a

def solution2():
    #l1 = [11, 2, 4]
    #l2 = [4, 5, 6]
    #l3 = [10, 8, -12]

    #a = [l1, l2, l3]

    a = getVals()

    dlr = 0
    drl = 0
    j = len(a) - 1

    for i in range(len(a)):
        dlr = dlr + a[i][i]
        drl = drl + a[i][j]
        j = j - 1

    difD = abs(dlr - drl)

    print(difD)

solution2()


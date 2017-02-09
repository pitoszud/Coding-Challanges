def solution():
    ls = [int(i) for i in input().strip().split()]
    maxNum = -900000
    minNum = 900000
    sumNum = 0
    for i in ls:
        sumNum = sumNum + i
        if minNum > i:
            minNum = i
        if maxNum < i:
            maxNum = i
    print(sumNum-maxNum, ' ', sumNum -minNum)

solution()

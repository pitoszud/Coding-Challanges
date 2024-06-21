import math
import sys

def solution():
    d = int(input())
    if d >= 1 and d <= 50:
        getAdvert(d)


def getAdvert(d):
    p = 5;
    ps = 0;
    for i in range(d):
        ps += math.floor(p // 2)
        p = math.floor(p // 2) * 3
    print(ps)


solution()


def solution2():
    n = int(input().strip())
    print(silnia(n))


def silnia(n):
    if (n < 0):
        return 0
    elif (n <= 1):
        return 1  # if n==1 or n==0, n! = 1
    return n * silnia(n - 1)  # n! = n * (n-1)!


solution()
#solution2()
def solution1():
    ls = list(map(lambda x: int(x), input("sol1. enter: ").strip().split()))
    print(ls)


def solution2():
    ls = [int(i) for i in input("sol2 enter: ").strip().split()]
    print(ls)


def solution3():
    ls = list(map(int, input("sol3 enter: ").strip().split()))
    print(ls)


def solution4():
    a, b, c = input("enter thee Integers: ").strip().split()
    a, b, c = [int(a), int(b), int(c)]
    print(a, ',', b, ',', c)


solution1()
solution2()
solution3()
solution4()

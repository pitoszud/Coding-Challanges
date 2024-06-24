
def solutionA():
    n, a = input(), sorted(map(int, input().split()))
    print(min(abs(x - y) for x, y in zip(a, a[1:])))


def solutionB():
    # 10
    # -59 -36 -13 1 -53 -92 -2 -96 -54 75
    nl = int(input())
    lc = [int(i) for i in input().strip().split()]
    lc.sort()
    print(lc)
    if const1(nl):
        if const2(lc):
            minV = abs(lc[len(lc)-1] - lc[0])
            for i in range(nl-1):
                tv = abs(lc[i] - lc[i+1])
                print(tv,'=',lc[i], '-', lc[i+1])
                if tv < minV:
                    minV = tv
            print(minV)


def const1(nl):
    chk = False
    if 2 <= nl <= 100000:
        chk = True
    return chk


def const2(vl):
    chk = True
    for i in vl:
        if i < -1000000000 or i > 1000000000:
            chk = False
            break
    return chk


solutionB()
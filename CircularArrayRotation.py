def solution():
    m, k, q = input().strip().split(' ')
    m, k, q = [int(m), int(k), int(q)]  # 3 2 3

    il = list(map(int, input().strip().split(' ')))  # 1 2 3

    ql = []  # 0 1 2
    for i in range(q):
        ql.append(int(input().strip()))

    for i in range(k):
        lastInt = il.pop(-1)
        il.insert(0, lastInt)

    chk = False
    if 1 <= m <= 100000:
        if 1 <= k <= 100000:
            if 1 <= q <= 500:
                chk = True

    if chk:
        for i in ql:
            print(il[i])


solution()
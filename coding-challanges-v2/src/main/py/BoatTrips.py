def solution3():
    a, b, c = input().strip().split()
    a, b, c = [int(a), int(b), int(c)]
    p = list(map(int, input().strip().split(' ')))

    q = True
    for i in p:
        if i > (b * c):
            q = False
            break
    if q:
        print('Yes')
    else:
        print('No')

solution3()

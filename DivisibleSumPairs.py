def solution():
    n, k = input().strip().split(' ')
    n, k = [int(n), int(k)]
    d = [int(i) for i in input().strip().split(' ')]

    chk = True
    if not 2 <= n <= 100:
        chk = False
        if not 2 <= k <= 100:
            chk = False
            for j in d:
                if not (1 <= d[j] <= 100):
                    chk = False


    if chk:
        c = 0
        for j in range(len(d)):
            print(d[j])
            for i in range(j+1, len(d)):
                print(' ',d[i])
                if ((d[j] + d[i]) % k) == 0:
                    print(' ',' ', d[j] + d[i])
                    c += 1
        print('counter',c)


solution()
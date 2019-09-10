def solution():
    sil = [41, 22, 80, 80, 41, 41, 41, 80, 22, 80, 22, 41, 41, 41, 80, 80, 22, 22, 22, 22, 41, 80, 80, 41, 22, 80, 80, 80, 80, 41, 22, 80, 22, 22, 22, 80, 22, 80, 80, 41, 22, 41, 41, 22, 22, 41, 22, 22, 80, 22, 22, 80, 41]
    ml = {}
    maxCount = 1
    for i in sil:
        if not i in ml:
            ml[i] = 1  # insert {i, 1}
        else:
            gi = ml[i] + 1  # get value of i
            ml[i] = gi  # insert {i, gi}
            if gi > maxCount:
                maxCount = gi
    sol = len(sil)-maxCount
    print(sol)

solution()



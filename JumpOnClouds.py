def joc():
    cl = [0, 0, 0, 1, 0, 0]
    i = 0
    c = 0
    while i < len(cl) - 1:
        if ((i + 2) > len(cl) - 1) or (cl[i + 2] == 1):
            i += 1
            c += 1
        else:
            i += 2
            c += 1
    print(c)


joc()

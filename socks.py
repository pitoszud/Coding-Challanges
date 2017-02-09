def solution():
    numSocks = int(input().strip())
    socks = []
    for i in range(numSocks):
        socks.append(input().strip())
    pairs = 0
    for i in set(socks):
        pairs += socks.count(i) // 2
    print(pairs)

solution()

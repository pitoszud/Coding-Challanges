def solution():
    S = "SOSSPSSQSSOR"

    # v1
    count = 0
    for i in range(len(S)):
        if S[i] != S[i % 3]:
            count += 1
    print(count)

    # v2
    print(sum([1 for x, y in zip(S, 'SOS' * 100) if x != y]))

    # v3
    print(len([1 for x, y in zip(S, 'SOS' * 33) if x != y]))


solution()
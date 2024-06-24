def solution():
    s = input().strip()
    n = int(input().strip())
    charCount = 0
    for i in s:
        if i == 'a':
            charCount += 1
    d = n // len(s)
    r = n % len(s)
    sol = charCount * d
    for j in range(r):
        if j == 'a':
            sol += 1
    print(sol)

solution()

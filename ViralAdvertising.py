def solution():
    d = int(input())
    if d >= 1 and d <= 50:
        likeNum(d, 5)

def likeNum(d,p):
  if d == 1:
    print(p)
  else:
    d = d - 1
    p = (p//2)*3
    likeNum(d,p)

solution()
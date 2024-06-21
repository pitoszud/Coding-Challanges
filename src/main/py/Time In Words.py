hDict1 = {
    1: 'one',
    2: 'two',
    3: 'three',
    4: 'four',
    5: 'five',
    6: 'six',
    7: 'seven',
    8: 'eight',
    9: 'nine',
    10: 'ten',
    11: 'eleven',
    12: 'twelve',
    13: 'thirteen',
    20: 'twenty',
}


def getH1(h):
    return hDict1[h]


def getT1(h, m):
    s = ''
    if m == 0 or m == 00:
        s = getH1(h) + " o'clock"
    elif m == 30:
        s = 'half past ' + getH1(h)
    elif m == 45:
        s = 'quarter to ' + getH1(h+1)
    elif m == 15:
        s = 'quarter past ' + getH1(h)
    elif m == 13:
        s = 'thirteen past ' + getH1(h)
    elif m == 20:
        s = getH1(m) + ' past ' + getH1(h)
    else:
        getT2(h,m)

def getT2(h,m):
    s = ''
    if 13 < m < 20:
        s = getTeen(m) + ' past ' + h
    elif 20 < m < 30:
        getH1(h) + ' ' + getH1(20) + getH1(h-20)

def getTeen(m):
    return hDict1[m-10] + 'teen'





print(getH1(12))

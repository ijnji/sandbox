import math

def solution(N):
    L = int(math.floor(math.log(N, 2)))
    cnt = 0
    res = 0
    for i in xrange(0, L):
        nxt = N & (1 << i + 1)
        cur = N & (1 << i)
        if cnt == 0:
            if cur and not nxt:
                cnt = 1
        else:
            if nxt:
                res = max(res, cnt)
                cnt = 0
            else:
                cnt += 1
    return res
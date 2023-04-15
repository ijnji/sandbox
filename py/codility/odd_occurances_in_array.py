def solution(A):
    res = 0
    for a in A:
        res ^= a
    return res
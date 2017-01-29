def solution(A, K):
    if len(A) == 0: return A
    while K > 0:
        rot(A)
        K -= 1
    return A

def rot(A):
    lst = A[len(A) - 1]
    for i in reversed(xrange(1, len(A))):
        A[i] = A[i - 1]
    A[0] = lst
    return A
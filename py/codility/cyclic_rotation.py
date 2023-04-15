def solution(A, K):
    if len(A) == 0: return A
    K = K % len(A)
    if K == 0: return A
    return A[-K:len(A)] + A[0:len(A) - K]
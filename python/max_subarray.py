#!/usr/bin/python
#
# Description:
#
# Find the maximum sum of a subarray of array A.

def max_subarray_brute(A):
    lrg = A[0]
    for i in xrange(len(A)):
        for j in xrange(i, len(A)):
            su = sum(A[i:j + 1])
            lrg = max(lrg, su)
    return lrg

def max_subarray_brute_quick(A):
    su = 0
    S = []
    for v in A:
        su += v
        S.append(su)
    lrg = A[0]
    for i in xrange(len(A)):
        for j in xrange(i, len(A)):
            su = S[j] if i == 0 else S[j] - S[i - 1]
            lrg = max(lrg, su)
    return lrg

def max_subarray_divcon(A):
    def recurse(l, r):
        if l == r: return A[l]
        m = (l + r + 1) / 2
        maxML = A[m - 1]
        su = 0
        for i in reversed(xrange(l, m)):
            su += A[i]
            maxML = max(maxML, su)
        maxMR = A[m]
        su = 0
        for i in xrange(m, r + 1):
            su += A[i]
            maxMR = max(maxMR, su)
        maxM = maxML + maxMR
        maxL = recurse(l, m - 1)
        maxR = recurse(m, r)
        return max(maxM, maxL, maxR)
    return recurse(0, len(A) - 1)

def max_subarray_dp(A):
    lrg = A[0]
    su = 0
    for v in A:
        su += v
        if lrg < su: lrg = su
        if su < 0: su = 0
    return lrg

def simple_test():
    stimulus = [
        ([3], 3),
        ([5, 5, -10, 5, 1], 10),
        ([0, 0, 0], 0),
        ([-1, -1], -1),
        ([-1, -1, 5, -1, -1], 5)
    ]
    for stm, exp in stimulus:
        assert(max_subarray_brute(stm) == exp)
        assert(max_subarray_brute_quick(stm) == exp)
        assert(max_subarray_divcon(stm) == exp)
        assert(max_subarray_dp(stm) == exp)

if __name__ == '__main__':
    simple_test()

#!/usr/bin/python
#
# Description:
#
# Find the maximum sum of a subarray of array A.

def max_subarray_brute(A):
    lrg = 0
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
    lrg = 0
    for i in xrange(len(A)):
        for j in xrange(i, len(A)):
            su = S[j] if i == 0 else S[j] - S[i - 1]
            lrg = max(lrg, su)
    return lrg

def max_subarray_dp(A):
    sml = lrg = su = 0
    for v in A:
        su += v
        if (su < sml): sml = su
        if (su - sml > lrg): lrg = su - sml
    return lrg

def simple_test():
    stimulus = [
        ([3], 3),
        ([5, 5, -10, 5, 1], 10),
        ([0, 0, 0], 0),
        ([-1], 0)
    ]
    for stm, exp in stimulus:
        assert(max_subarray_brute(stm) == exp)
        assert(max_subarray_brute_quick(stm) == exp)
        assert(max_subarray_dp(stm) == exp)

if __name__ == '__main__':
    simple_test()

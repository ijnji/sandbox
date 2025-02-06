#!/usr/bin/env python3
#
# Description:
#
# Parition an array, A, in-place such that elements are in the following order:
# elements less than A[pivot], elements equal to A[pivot], elements greater
# than A[pivot].

def partition_with_pivot(p, A):
    pv = A[p]
    next_l, next_m, next_r = 0, 0, len(A) - 1
    while next_m <= next_r:
        if A[next_m] < pv:
            A[next_l], A[next_m] = A[next_m], A[next_l]
            next_l += 1
            next_m += 1
        elif A[next_m] == pv:
            next_m += 1
        else:
            A[next_r], A[next_m] = A[next_m], A[next_r]
            next_r -= 1
    return A

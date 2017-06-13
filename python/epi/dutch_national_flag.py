#!/usr/bin/env python3
#
# Description:
#
# Parition an array, A, in-place such that elements are in the following order:
# elements less than A[pivot], elements equal to A[pivot], elements greater
# than A[pivot].

from rlib.testing_utils import expect

def dutch_flag_parition(p, A):
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

def small_test():
    p, A = 0, [1]
    pv = A[p]
    expect(dutch_flag_parition(p, A)).to_pass(checker, pv)
    p, A = 1, [1, 2, 3]
    pv = A[p]
    expect(dutch_flag_parition(p, A)).to_pass(checker, pv)
    p, A = 0, [3, 2, 1]
    pv = A[p]
    expect(dutch_flag_parition(p, A)).to_pass(checker, pv)
    p, A = 3, [0, 1, 2, 0, 2, 1, 1]
    pv = A[p]
    expect(dutch_flag_parition(p, A)).to_pass(checker, pv)

def checker(result, args):
    B, pv = result, args[0]
    i = 0;
    while i < len(B) and B[i] < pv: i += 1
    while i < len(B) and B[i] == pv: i += 1
    while i < len(B) and B[i] > pv: i += 1
    return i == len(B)

if __name__ == '__main__':
    small_test()

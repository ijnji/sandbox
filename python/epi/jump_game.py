#!/usr/bin/python
#
# Description:
#
# Given an array of integers A, where A[i] denotes max possible moves starting from i.
# Return if it's possible to move to last index of A starting from i = 0.

from rlib.testing import expect

def can_reach_end(max_advance_steps):
    end = len(max_advance_steps) - 1
    far = 0
    for i, v in enumerate(max_advance_steps):
        if i > far: return False
        far = max(far, i + v)
        if far >= end: return True
    return false

def small_test():
    expect(can_reach_end([2, 3, 1, 1, 4]), True)
    expect(can_reach_end([3, 2, 1, 0, 4]), False)
    expect(can_reach_end([3, 2, 1, -10, 4]), False)
    expect(can_reach_end([2, 3, -1, -1, 4]), True)
    expect(can_reach_end([2, 2, -1, -1, 100]), False)

if __name__ == '__main__':
    small_test()

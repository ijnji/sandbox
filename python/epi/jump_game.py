#!/usr/bin/env python3
#
# Description:
#
# Given an array of integers A, where A[i] denotes max possible moves
# starting from i, return whether or not it's possible to move from
# i = 0 to the last index, i = |A| - 1.

from rlib.testing_utils import expect

def can_reach_end(max_advance_steps):
    end = len(max_advance_steps) - 1
    far = 0
    for i, v in enumerate(max_advance_steps):
        if i > far: return False
        far = max(far, i + v)
        if far >= end: return True
    return false

def small_test():
    expect(can_reach_end([2, 3, 1, 1, 4])).to_be(True)
    expect(can_reach_end([3, 2, 1, 0, 4])).to_be(False)
    expect(can_reach_end([3, 2, 1, -10, 4])).to_be(False)
    expect(can_reach_end([2, 3, -1, -1, 4])).to_be(True)
    expect(can_reach_end([2, 2, -1, -1, 100])).to_be(False)

if __name__ == '__main__':
    small_test()

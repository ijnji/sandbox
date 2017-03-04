#!/usr/bin/python
#
# Description:
#
# Given an array of integers A, where A[i] denotes max possible moves starting from i.
# Return if it's possible to move to last index of A starting from i = 0.

def canReachEnd(maxAdvanceSteps):
    end = len(maxAdvanceSteps) - 1
    far = 0
    for i, v in enumerate(maxAdvanceSteps):
        if i > far: return False
        far = max(far, i + v)
        if far >= end: return True
    return false

def smallTest():
    assert(canReachEnd([2, 3, 1, 1, 4]))
    assert(not canReachEnd([3, 2, 1, 0, 4]))
    assert(not canReachEnd([3, 2, 1, -10, 4]))
    assert(canReachEnd([2, 3, -1, -1, 4]))
    assert(not canReachEnd([2, 2, -1, -1, 100]))

if __name__ == '__main__':
    smallTest()

#!/usr/bin/env python3
#
# Description:
#
# Given an array of integers A, where A[i] denotes max possible moves
# starting from i, return whether or not it's possible to move from
# i = 0 to the last index, i = |A| - 1.

def can_reach_end(max_advance_steps):
    end = len(max_advance_steps) - 1
    far = 0
    for i, v in enumerate(max_advance_steps):
        if i > far: return False
        far = max(far, i + v)
        if far >= end: return True
    return false

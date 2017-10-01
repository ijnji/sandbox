#!/usr/bin/env python3

import pytest

from epi.dutch_national_flag import partition_with_pivot

def checker(B, pv):
    i = 0;
    while i < len(B) and B[i] < pv: i += 1
    while i < len(B) and B[i] == pv: i += 1
    while i < len(B) and B[i] > pv: i += 1
    return i == len(B)

def test_small():
    p, A = 0, [1]
    pv = A[p]
    assert(checker(partition_with_pivot(p, A), pv))
    p, A = 1, [1, 2, 3]
    pv = A[p]
    assert(checker(partition_with_pivot(p, A), pv))
    p, A = 0, [3, 2, 1]
    pv = A[p]
    assert(checker(partition_with_pivot(p, A), pv))
    p, A = 3, [0, 1, 2, 0, 2, 1, 1]
    pv = A[p]
    assert(checker(partition_with_pivot(p, A), pv))

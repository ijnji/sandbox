#!/usr/bin/env python3
#
# Description:
#
# Given an integer array, output all unique pairs that sum up to a specific
# value k. Ignore the instances of each value.

from rlib.testing_utils import expect

def array_pair_sum(values, k):
    s = set()
    res = set()
    for v in values: s.add(v)
    for v in s:
        diff = k - v
        if diff in s: res.add((min(v, diff), max(v, diff)))
    return list(res)

def simple_test():
    values, k = [1, 2, 3, 4, 5, 6, 7, 8, 9], 10
    result = sorted(array_pair_sum(values, k))
    expect(result).to_be([
        (1, 9), (2, 8), (3, 7), (4, 6), (5, 5)
    ])

    values, k = [1, 2, 3, 4, 5, 6, 7, 8, 9], 1
    result = sorted(array_pair_sum(values, k))
    expect(result).to_be([])

if __name__ == '__main__':
    simple_test()

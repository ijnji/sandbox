#!/usr/bin/env python3
#
# Description:
#
# Given an NxM 2D grid, count the number of unique paths from the top-left
# corner to the bottom-right corner. Going up, down, left, and right are the
# only valid movements.

from rlib.testing_utils import expect

def number_of_ways(n, m):
    memo = [[0 for j in range(m)] for i in range(n)]
    for j in range(m): memo[0][j] = 1
    for i in range(n): memo[i][0] = 1
    for i in range(1, n):
        for j in range(1, m):
            memo[i][j] = memo[i - 1][j] + memo[i][j - 1]
    return memo[n - 1][m - 1]

def small_test():
    expect(number_of_ways(1, 1)).to_be(1)
    expect(number_of_ways(1, 5)).to_be(1)
    expect(number_of_ways(5, 1)).to_be(1)
    expect(number_of_ways(5, 5)).to_be(70)

if __name__ == '__main__':
    small_test()

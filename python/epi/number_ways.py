#!/usr/bin/env python3
#
# Description:
#
# Given an R-C 2D grid, count the number of paths from (0, 0), the top-left
# corner, to (R, C), the bottom-right corner, and the only two movement options
# are moving right and moving down.

from rlib.testing_utils import expect

def number_of_ways(r, c):
    if r == 0 or c == 0: return 1
    memo = [[0 for x in range(c)] for y in range(r)]
    for x in range(c): memo[0][x] = 1
    for y in range(r): memo[y][0] = 1
    for y in range(1, r):
        for x in range(1, c):
            memo[y][x] = memo[y - 1][x] + memo[y][x - 1]
    return memo[r - 1][c - 1]

def small_test():
    expect(number_of_ways(0, 0)).to_be(1)
    expect(number_of_ways(1, 1)).to_be(1)
    expect(number_of_ways(2, 2)).to_be(2)
    expect(number_of_ways(1, 5)).to_be(1)
    expect(number_of_ways(4, 3)).to_be(10)
    expect(number_of_ways(5, 5)).to_be(70)

if __name__ == '__main__':
    small_test()

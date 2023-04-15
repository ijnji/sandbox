#!/usr/bin/env python3
#
# Description:
#
# Given a triangle as an array of arrays, defining each row of the triangle
# starting from the top row, to the bottom row. The rows comprise of integers
# weights, and have lengths 1, 2, ..., n. Find a path starting from the top,
# ending at the bottom, with minimum total weight.

import sys

def find_minimum_path(triangle):
    memo_w = [[0] * (i + 1) for i in range(len(triangle))]
    memo_p = [[0] * (i + 1) for i in range(len(triangle))]
    memo_w[0][0] = triangle[0][0]
    for i in range(1, len(memo_w)):
        for j in range(len(memo_w[i])):
            prev_l = memo_w[i - 1][j - 1] if j > 0 else sys.maxsize
            prev_r = memo_w[i - 1][j] if j < len(memo_w[i]) - 1 else sys.maxsize
            memo_w[i][j] = triangle[i][j] + min(prev_l, prev_r)
            if prev_r < prev_l: memo_p[i][j] = j
            else: memo_p[i][j] = j - 1

    res = []
    val, idx = min((val, idx) for (idx, val) in enumerate(memo_w[-1]))
    for i in reversed(range(len(memo_p))):
        res.append(triangle[i][idx])
        idx = memo_p[i][idx]
    res.reverse()
    return res

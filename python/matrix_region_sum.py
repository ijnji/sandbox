#!/usr/bin/env python3
#
# Description:
#
# Given an initial matrix of positive integers, write a function that returns the sum of all
# integers in a rectangular region. The function will be called multiple times with different
# regions, optimize accordingly.

from rlib.testing_utils import expect

def region_sums_initialize(matrix):
    region_sums = [[0 for j in range(len(matrix[0]))] for i in range(len(matrix))]
    for i in range(len(matrix)):
        row_sum = 0
        for j in range(len(matrix[i])):
            top_sum = region_sums[i - 1][j] if i > 0 else 0
            row_sum += matrix[i][j]
            region_sums[i][j] = row_sum + top_sum
    return region_sums

def matrix_region_sum(region_sums, top_left, bottom_right):
    r1, c1 = top_left
    r2, c2 = bottom_right
    top_sum = region_sums[r1 - 1][c2] if r1 > 0 else 0
    left_sum = region_sums[r2][c1 - 1] if c1 > 0 else 0
    corner_sum = region_sums[r1 - 1][c1 - 1] if r1 > 0 and c1 > 0 else 0
    whole_sum = region_sums[r2][c2]
    return whole_sum - top_sum - left_sum + corner_sum

def simple_test():
    matrix = [
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
    ];
    region_sums = region_sums_initialize(matrix)
    top_left, bottom_right = (1, 1), (3, 3)
    expect(matrix_region_sum(region_sums, top_left, bottom_right)).to_be(9)
    top_left, bottom_right = (0, 0), (4, 0)
    expect(matrix_region_sum(region_sums, top_left, bottom_right)).to_be(5)
    top_left, bottom_right = (0, 0), (0, 4)
    expect(matrix_region_sum(region_sums, top_left, bottom_right)).to_be(5)
    top_left, bottom_right = (4, 4), (4, 4)
    expect(matrix_region_sum(region_sums, top_left, bottom_right)).to_be(1)

    matrix = [
        [1, 2, 3, 4],
        [1, 2, 3, 4],
        [1, 2, 3, 4],
        [1, 2, 3, 4],
    ];
    region_sums = region_sums_initialize(matrix)
    top_left, bottom_right = (1, 1), (2, 3)
    expect(matrix_region_sum(region_sums, top_left, bottom_right)).to_be(18)

if __name__ == '__main__':
    simple_test()

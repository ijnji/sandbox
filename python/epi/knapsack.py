#!/usr/bin/env python3
#
# Description:
#
# Given a set of items each with a weight and value, and a knapsack with a max
# weight capacity, return the subset of items with the highest total value while
# staying within the knapsack capactiy constraint.

from rlib.testing_utils import expect

def knapsack(items, capacity):
    memo = [[0 for j in range(capacity + 1)] for i in range(len(items))]
    for i in range(len(items)):
        for j in range(capacity + 1):
            v = items[i][0]
            w = items[i][1]
            if j < w:
                memo[i][j] = memo[i - 1][j] if i > 0 else 0
            else:
                with_curr = v + memo[i - 1][j - w] if i > 0 else v
                without_curr = memo[i - 1][j] if i > 0 else 0
                memo[i][j] = max(without_curr, with_curr)
    return memo[len(items) - 1][capacity]

def small_test():
    items = [
        (60, 5), (50, 3), (70, 4), (30, 2)
    ];
    capacity = 5
    expect(knapsack(items, capacity)).to_be(80)

    items = [
        (65, 20), (35, 8), (245, 60), (195, 55), (65, 40), (150, 70), (275, 85),
        (155, 25), (120, 30), (320, 65), (75, 75), (40, 10), (200, 95),
        (100, 50), (220, 40), (99, 10)
    ];
    capacity = 130
    expect(knapsack(items, capacity)).to_be(695)

if __name__ == '__main__':
    small_test()

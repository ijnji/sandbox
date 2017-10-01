#!/usr/bin/env python3
#
# Description:
#
# Given a set of items each with a weight and value, and a knapsack with a max
# weight capacity, return the subset of items with the highest total value while
# staying within the knapsack capactiy constraint.

def find_max_value(items, capacity):
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

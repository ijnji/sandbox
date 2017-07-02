#!/usr/bin/env python3
#
# Description:
#
# Compute the binomial coefficient of x^k term of the (1 + x)^n expansion.
# Remember that the coefficient equals n Cr k.

from rlib.testing_utils import expect

def compute_n_choose_k(n, k):

    memo = [[0 for j in range(k + 1)] for i in range(n + 1)]
    for i in range(n + 1):
        for j in range(k + 1):
            if j in (0, n):
                memo[i][j] = 1
            else:
                without_j = memo[i - 1][j]
                with_j = memo[i - 1][j - 1]
                memo[i][j] = without_j + with_j
    return memo[n][k]

def small_test():
    expect(compute_n_choose_k(0, 0)).to_be(1)
    expect(compute_n_choose_k(1, 1)).to_be(1)
    expect(compute_n_choose_k(12, 0)).to_be(1)
    expect(compute_n_choose_k(12, 5)).to_be(792)

if __name__ == '__main__':
    small_test()

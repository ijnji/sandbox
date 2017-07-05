#!/usr/bin/env python3
#
# Description:
#
# Compute the coefficient of the x^k term of the binomial expansion (1 + x)^n.
# The value of the coefficient is also the value of n Cr k.

from rlib.testing_utils import expect

def binomial_coefficient(n, k):
    memo = [[0] * (i + 1) for i in range(n + 1)]
    for i in range(n + 1):
        for j in range(i + 1):
            if j in (0, i):
                memo[i][j] = 1
            else:
                without_j = memo[i - 1][j]
                with_j = memo[i - 1][j - 1]
                memo[i][j] = without_j + with_j
    return memo[n][k]

def small_test():
    expect(binomial_coefficient(1, 0)).to_be(1)
    expect(binomial_coefficient(1, 1)).to_be(1)
    expect(binomial_coefficient(5, 1)).to_be(5)
    expect(binomial_coefficient(5, 3)).to_be(10)
    expect(binomial_coefficient(10, 4)).to_be(210)

if __name__ == '__main__':
    small_test()

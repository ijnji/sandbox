#!/usr/bin/env python3
#
# Description:
#
# Given an even list of coins with integer values, two players take turns
# choosing and keep a coin from either end of the current list. Find the maximum
# total revenue of the first player if both players play optimally.

def find_revenue_recursive(coins):
    memo = [[-1] * len(coins) for i in range(len(coins))]
    def find_revenue_helper(a, b):
        if a > b: return 0
        if memo[a][b] == -1:
            left = coins[a] + min(
                find_revenue_helper(a + 2, b),
                find_revenue_helper(a + 1, b - 1)
            )
            right = coins[b] + min(
                find_revenue_helper(a, b - 2),
                find_revenue_helper(a + 1, b - 1)
            )
            memo[a][b] = max(left, right)
        return memo[a][b]
    return find_revenue_helper(0, len(coins) - 1)

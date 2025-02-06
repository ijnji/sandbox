#!/usr/bin/env python3
#
# Description:
#
# Given an even list of coins with integer values, two players take turns
# choosing and keep a coin from either end of the current list. Find the maximum
# total revenue of the first player if both players play optimally.

from enum import Enum

class Turn(Enum):
    ONE = 1
    TWO = 2

def find_revenue_recursive(coins):
    memo = [[-1] * len(coins) for i in range(len(coins))]
    def find_revenue_helper(turn, score_one, score_two, a, b):
        if a > b: return score_one
        if memo[a][b] == -1:
            if turn is Turn.ONE:
                left = find_revenue_helper(Turn.TWO, score_one + coins[a], score_two, a + 1, b)
                right = find_revenue_helper(Turn.TWO, score_one + coins[b], score_two, a, b - 1)
            else:
                left = find_revenue_helper(Turn.ONE, score_one, score_two + coins[a], a + 1, b)
                right = find_revenue_helper(Turn.ONE, score_one, score_two + coins[b], a, b - 1)
            memo[a][b] = max(left, right)
        return memo[a][b]

    return find_revenue_helper(Turn.ONE, 0, 0, 0, len(coins) - 1)

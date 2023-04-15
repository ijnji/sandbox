#!/usr/bin/env python3
#
# Description:
#
# Write a function that counts how many different ways there are to climb a staircase, given the
# n, the number of steps in the staircase, and k, the maximum number of steps that can be taken at
# once.

def count_climbing_route(n, k):
    memo = [-1 for i in range(n)]
    memo[0] = 1
    def helper(pos):
        if memo[pos] == -1:
            routes = 0
            for i in range(1, k + 1):
                if (pos - i >= 0):
                    routes += helper(pos - i)
            memo[pos] = routes
        return memo[pos]
    return helper(n - 1)

#!/usr/bin/env python3
#
# Description:
#
# Find the maximium profit to be had given an array of a ticker's daily prices
# if you can only buy and sell the stock once.

def find_max_profit(prices):
    lowest, profitist = float('inf'), 0.0
    for p in prices:
        if (p - lowest) > profitist: profitist = p - lowest
        if p < lowest: lowest = p
    return profitist

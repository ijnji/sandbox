#!/usr/bin/env python3
#
# Description:
#
# Find the maximium profit to be had given an array of a ticker's daily prices
# if you can only buy and sell the stock once.

from rlib.testing_utils import expect

def buy_and_sell_stock(prices):
    lowest, profitist = float('inf'), 0.0
    for p in prices:
        if (p - lowest) > profitist: profitist = p - lowest
        if p < lowest: lowest = p
    return profitist

def small_test():
    prices = [1, 2]
    profit = 1
    expect(buy_and_sell_stock(prices)).to_be(profit)
    prices = [310, 315, 275, 295, 260, 270, 290, 230, 255, 250]
    profit = 30
    expect(buy_and_sell_stock(prices)).to_be(profit)
    prices = [310, 310, 275, 275, 260, 260, 260, 230, 230, 230]
    profit = 0
    expect(buy_and_sell_stock(prices)).to_be(profit)

if __name__ == '__main__':
    small_test()

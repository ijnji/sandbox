#!/usr/bin/env python3

import pytest

from epi.buy_and_sell_stock import find_max_profit

def test_small():
    prices = [1, 2]
    profit = 1
    assert(find_max_profit(prices) == profit)
    prices = [310, 315, 275, 295, 260, 270, 290, 230, 255, 250]
    profit = 30
    assert(find_max_profit(prices) == profit)
    prices = [310, 310, 275, 275, 260, 260, 260, 230, 230, 230]
    profit = 0
    assert(find_max_profit(prices) == profit)

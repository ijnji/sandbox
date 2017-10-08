#!/usr/bin/env python3

import pytest

from epi.coin_game import find_revenue_recursive

def test_small():
    coins = [10, 25, 5, 1, 10, 5]
    assert(find_revenue_recursive(coins) == 31)

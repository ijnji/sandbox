#!/usr/bin/env python3

import pytest

from epi.coin_game import find_revenue_recursive

def test_small():
    n, k = 4, 2
    assert(count_climbing_route(n, k) == 5)
    n, k = 5, 3
    assert(count_climbing_route(n, k) == 7)
    n, k = 5, 1
    assert(count_climbing_route(n, k) == 1)

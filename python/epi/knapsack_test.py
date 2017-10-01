#!/usr/bin/env python3

import pytest

from epi.knapsack import find_max_value

def test_small():
    items = [
        (60, 5), (50, 3), (70, 4), (30, 2)
    ];
    capacity = 5
    assert(find_max_value(items, capacity) == 80)

    items = [
        (65, 20), (35, 8), (245, 60), (195, 55), (65, 40), (150, 70), (275, 85),
        (155, 25), (120, 30), (320, 65), (75, 75), (40, 10), (200, 95),
        (100, 50), (220, 40), (99, 10)
    ];
    capacity = 130
    assert(find_max_value(items, capacity) == 695)

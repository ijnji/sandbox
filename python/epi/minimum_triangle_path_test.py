#!/usr/bin/env python3

import pytest

from epi.minimum_triangle_path import find_minimum_path

def test_small():
    triangle = [
        [2],
        [4, 4],
        [8, 5, 6],
        [4, 2, 6, 2],
        [1, 5, 2, 3, 4]
    ]
    assert(find_minimum_path(triangle) == [2, 4, 5, 2, 2])

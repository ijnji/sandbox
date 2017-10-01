#!/usr/bin/env python3

import pytest

from epi.computing_binomial_coefficient import find_coefficient

def test_small():
    assert(find_coefficient(1, 0) == 1)
    assert(find_coefficient(1, 1) == 1)
    assert(find_coefficient(5, 1) == 5)
    assert(find_coefficient(5, 3) == 10)
    assert(find_coefficient(10, 4) == 210)

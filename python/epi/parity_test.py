#!/usr/bin/env python3

from epi.parity import parity
import pytest

def test_small():
    assert(parity(0b0) == 0)
    assert(parity(0b1) == 1)
    assert(parity(0b1011) == 1)
    assert(parity(0b10001000) == 0)

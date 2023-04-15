#!/usr/bin/env python3

import pytest

from epi.jump_game import can_reach_end

def test_small():
    assert(can_reach_end([2, 3, 1, 1, 4]) == True)
    assert(can_reach_end([3, 2, 1, 0, 4]) == False)
    assert(can_reach_end([3, 2, 1, -10, 4]) == False)
    assert(can_reach_end([2, 3, -1, -1, 4]) == True)
    assert(can_reach_end([2, 2, -1, -1, 100]) == False)

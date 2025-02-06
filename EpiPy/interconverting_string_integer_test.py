#!/usr/bin/env python3

import pytest

from epi.interconverting_string_integer import int_to_string
from epi.interconverting_string_integer import string_to_int

def test_small():
    assert(int_to_string(0) == '0')
    assert(int_to_string(-1) == '-1')
    assert(int_to_string(1) == '1')
    assert(int_to_string(1000) == '1000')
    assert(int_to_string(2147483646) == '2147483646')
    assert(int_to_string(-2147483646) == '-2147483646')
    assert(string_to_int('0') == 0)
    assert(string_to_int('-1') == -1)
    assert(string_to_int('1') == 1)
    assert(string_to_int('1000') == 1000)
    assert(string_to_int('2147483646') == 2147483646)
    assert(string_to_int('-2147483646') == -2147483646)

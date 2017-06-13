#!/usr/bin/env python3
#
# Description:
#
# Interconvert string and integer. Handle negative values.

from rlib.testing_utils import expect

def int_to_string(value):
    if value == 0: return '0'
    if value < 0:
        neg = True
        value = -value
    else:
        neg = False
    res = []
    while value > 0:
        res.append(str(value % 10))
        value //= 10
    if neg: res.append('-')
    res.reverse()
    return ''.join(res)

def string_to_int(value):
    res = 0
    for s in value[value[0] == '-':]:
        res *= 10
        res += ord(s) - ord('0')
    return -res if value[0] == '-' else res

def small_test():
    expect(int_to_string(0)).to_be('0')
    expect(int_to_string(-1)).to_be('-1')
    expect(int_to_string(1)).to_be('1')
    expect(int_to_string(1000)).to_be('1000')
    expect(int_to_string(2147483646)).to_be('2147483646')
    expect(int_to_string(-2147483646)).to_be('-2147483646')
    expect(string_to_int('0')).to_be(0)
    expect(string_to_int('-1')).to_be(-1)
    expect(string_to_int('1')).to_be(1)
    expect(string_to_int('1000')).to_be(1000)
    expect(string_to_int('2147483646')).to_be(2147483646)
    expect(string_to_int('-2147483646')).to_be(-2147483646)

if __name__ == '__main__':
    small_test()

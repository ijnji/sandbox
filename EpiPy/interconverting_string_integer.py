#!/usr/bin/env python3
#
# Description:
#
# Interconvert string and integer. Handle negative values.

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

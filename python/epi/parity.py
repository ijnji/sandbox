#!/usr/bin/env python3
#
# Description:
#
# Comput the parity of a word.

from rlib.testing_utils import expect

def parity(word):
    p = 0
    while word > 0:
        word &= word - 1
        p ^= 1
    return p

def small_test():
    expect(parity(0b0)).to_be(0)
    expect(parity(0b1)).to_be(1)
    expect(parity(0b1011)).to_be(1)
    expect(parity(0b10001000)).to_be(0)

if __name__ == '__main__':
    small_test()

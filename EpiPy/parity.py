#!/usr/bin/env python3
#
# Description:
#
# Comput the parity of a word.

def parity(word):
    p = 0
    while word > 0:
        word &= word - 1
        p ^= 1
    return p

#!/usr/bin/env python3
#
# Description:
#
# The function read_4(buffer) will read up to 4 bytes into buffer, returning
# the amount read as an integer. Additional calls will continue reading from
# previous calls. Write a function to read N bytes using read_4(buffer).

from rlib.testing_utils import expect

def make_read_4(blob):
    blob_idx = 0
    def read_4(buffer):
        # Assume len(buffer) == 4
        idx = 0
        nonlocal blob_idx
        while idx < 4 and blob_idx < len(blob):
            buffer[idx] = blob[blob_idx]
            idx += 1
            blob_idx += 1
        return idx
    return read_4

def read_n(read_4, buffer, n):
    # Assume len(buffer) == n
    idx = 0
    cache = bytearray([0] * 4)
    cache_idx = 0
    cache_amount = 0
    while idx < n:
        if cache_idx >= cache_amount:
            cache_amount = read_4(cache)
            cache_idx = 0
            if cache_amount == 0: break
        buffer[idx] = cache[cache_idx]
        idx += 1
        cache_idx += 1
    return idx

def simple_test():
    blob = bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12])
    read_4 = make_read_4(blob)
    n = 12
    buffer = bytearray([0] * n)
    n_read = read_n(read_4, buffer, n)
    expect(n_read).to_be(12)
    expect(buffer).to_be(bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]))

    blob = bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12])
    read_4 = make_read_4(blob)
    n = 3
    buffer = bytearray([0] * n)
    n_read = read_n(read_4, buffer, n)
    expect(n_read).to_be(3)
    expect(buffer).to_be(bytearray([1, 2, 3]))

    blob = bytearray([1, 2, 3, 4, 5])
    read_4 = make_read_4(blob)
    n = 8
    buffer = bytearray([0] * n)
    n_read = read_n(read_4, buffer, n)
    expect(n_read).to_be(5)
    expect(buffer).to_be(bytearray([1, 2, 3, 4, 5, 0, 0, 0]))

    blob = bytearray([1, 2, 3, 4, 5])
    read_4 = make_read_4(blob)
    n = 1
    buffer = bytearray([0] * n)
    n_read = read_n(read_4, buffer, n)
    expect(n_read).to_be(1)
    expect(buffer).to_be(bytearray([1]))

    blob = bytearray([1, 2, 3, 4, 5])
    read_4 = make_read_4(blob)
    n = 0
    buffer = bytearray([0] * n)
    n_read = read_n(read_4, buffer, n)
    expect(n_read).to_be(0)
    expect(buffer).to_be(bytearray([]))

if __name__ == '__main__':
    simple_test()

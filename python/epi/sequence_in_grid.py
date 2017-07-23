#!/usr/bin/env python3
#
# Description:
#
# Given a 2D array, and a sequence of natural numbers, return whether or not
# the sequence can be found in the 2D array by returning a list of their
# indices. And if not, return an empty list. Indices up, down, left, and right
# from each other are adjacent.

from rlib.testing_utils import expect

def sequence_in_grid(grid, pattern):
    memo = set()

    def sequence_recurse(r, c, offset):
        if offset == len(pattern): return True
        if (
            0 <= r < len(grid) and
            0 <= c < len(grid[r]) and
            grid[r][c] == pattern[offset] and
            (r, c, offset) not in memo
        ):
            up = sequence_recurse(r - 1, c, offset + 1)
            down = sequence_recurse(r + 1, c, offset + 1)
            left = sequence_recurse(r, c - 1, offset + 1)
            right = sequence_recurse(r, c + 1, offset + 1)
            if up or down or left or right: return True
        memo.add((r, c, offset))
        return False

    for r in range(len(grid)):
        for c in range(len(grid[r])):
            if sequence_recurse(r, c, 0): return True
    return False

def small_test():
    grid = [
        [1, 2, 3],
        [3, 4, 5],
        [5, 6, 7]
    ]
    seq = [5]
    expect(sequence_in_grid(grid, seq)).to_be(True)
    seq = [1, 3, 4, 6]
    expect(sequence_in_grid(grid, seq)).to_be(True)
    seq = [7, 7, 7, 7]
    expect(sequence_in_grid(grid, seq)).to_be(False)

if __name__ == '__main__':
    small_test()

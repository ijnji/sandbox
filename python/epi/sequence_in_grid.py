#!/usr/bin/env python3
#
# Description:
#
# Given a 2D array, and a sequence of natural numbers, return whether or not
# the sequence can be found in the 2D array by returning a list of their
# indices. And if not, return an empty list. Indices up, down, left, and right
# from each other are adjacent.

from rlib.testing_utils import expect

def sequence_in_grid(grid, seq):
    pass

def small_test():
    seq = []
    grid = [[]]
    expect(sequence_in_grid(grid, seq)).to_be([])
    seq = [1, 2, 3]
    grid = [[5, 4, 3, 2, 1]]
    expect(sequence_in_grid(grid, seq)).to_be([
        (0, 4), (0, 3), (0, 2)
    ])

if __name__ == '__main__':
    small_test()

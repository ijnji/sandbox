#!/usr/bin/env python3
#
# Description:
#
# Given a dictionary of english words, and a pattern, write a function that
# returns a list of dictionary words that concatenates exactly to the pattern.

from collections import deque

def find_sequences(dictionary, pattern):
    # List of indices of the beginning of the last word in the decompositions of pattern[:i + 1]
    memo = [[] for i in range(len(pattern))]
    for i in range(len(pattern)):
        for j in reversed(range(i + 1)):
            suffix = pattern[j:i + 1]
            if suffix in dictionary and (j == 0 or len(memo[j - 1]) > 0):
                memo[i].append(j)

    que = deque([(len(pattern) - 1, [])])
    decompositions = []
    while len(que) > 0:
        curr = que.popleft()
        end = curr[0]
        decomp = curr[1]
        if end < 0:
            decompositions.append(decomp[::-1])
        else:
            for start in memo[end]:
                suffix = pattern[start:end + 1]
                copy_decomp = list(decomp)
                copy_decomp.append(suffix)
                que.append((start - 1, copy_decomp))
    return decompositions

#!/usr/bin/env python3
#
# Description:
#
# Find the Levenshtein distance between two given words. The Levenshtein
# distance is defined as the minimum number of edits needed to morph one word
# to another word, where the edit operations comprise of 1) replacing a letter,
# 2) inserting a letter, and 3) deleting a letter.

import sys

def find_levenshtein_distance(s1, s2):
    memo = [[-1 for _ in s2] for _ in s1]
    for i in range(len(s1)):
        for j in range(len(s2)):
            insertOp = memo[i - 1][j] if i - 1 >= 0 else None
            deleteOp = memo[i][j - 1] if j - 1 >= 0 else None
            replaceOp = memo[i - 1][j - 1] if i - 1 >= 0 and j - 1 >= 0 else None
            if insertOp == None and deleteOp == None and replaceOp == None:
                minOp = 0
            else:
                minOp = min(insertOp if insertOp != None else sys.maxsize,
                            deleteOp if deleteOp != None else sys.maxsize,
                            replaceOp if replaceOp != None else sys.maxsize)
            memo[i][j] = 0 if s1[i] == s2[j] else 1
            memo[i][j] += minOp
    return memo[-1][-1]

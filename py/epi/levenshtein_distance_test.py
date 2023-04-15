#!/usr/bin/env python3

import pytest

from epi.levenshtein_distance import find_levenshtein_distance

def test_small():
    s1, s2 = "a", "a"
    assert(find_levenshtein_distance(s1, s2) == 0);
    s1, s2 = "a", "b"
    assert(find_levenshtein_distance(s1, s2) == 1);
    s1, s2 = "abc", "abcd"
    assert(find_levenshtein_distance(s1, s2) == 1);
    s1, s2 = "Carthorse", "Orchestra"
    assert(find_levenshtein_distance(s1, s2) == 8); 

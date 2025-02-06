#!/usr/bin/env python3

import pytest

from rlib.language_utils import buildEnglishSet
from epi.bed_bath_beyond import find_sequences

def test_small():
    dictionary = buildEnglishSet()
    assert(find_sequences(dictionary, 'apple') == [
        ['a', 'pp', 'le'], ['app', 'le'], ['apple']
    ])
    assert(find_sequences(dictionary, 'bedbath') == [
        ['be', 'db', 'a', 'th'], ['bed', 'ba', 'th'], ['bed', 'bath']
    ])
    assert(find_sequences(dictionary, 'beyond') == [
        ['be', 'yo', 'nd'], ['be', 'yond'], ['beyond']
    ])

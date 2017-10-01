#!/usr/bin/env python3

import pytest

from rlib.language_utils import buildEnglishSet
from epi.bed_bath_beyond import find_sequences

def test_small():
    dictionary = buildEnglishSet()
    print('hello')
    # assert(find_sequences(dictionary, 'apple') == [
    #     ['apple'], ['app', 'le'], ['a', 'pp', 'le']
    # ])
    # assert(find_sequences(dictionary, 'bedbath') == [
    #     ['bed', 'bath'], ['bed', 'ba', 'th'], ['be', 'db', 'a', 'th']
    # ])
    # assert(find_sequences(dictionary, 'beyond') == [
    #     ['beyond'], ['be', 'yond'], ['be', 'yo', 'nd']
    # ])
    print(find_sequences(dictionary, 'apple'))
    print(find_sequences(dictionary, 'bedbath'))
    print(find_sequences(dictionary, 'beyond'))

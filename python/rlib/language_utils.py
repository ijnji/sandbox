#!/usr/bin/env python3

import os

def buildEnglishSet():
    location = os.path.join(os.getcwd(), os.path.dirname(__file__))
    location = os.path.join(location, 'language_english_words.txt')
    res = set()
    with open(location) as f:
        for word in f.readlines():
            res.add(word.strip().lower())
    return res

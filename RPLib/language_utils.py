#!/usr/bin/env python3

import urllib.request

URL = 'https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt'

def buildEnglishSet():
    try:
        res = set()
        words = urllib.request.urlopen(URL).read().decode('utf-8').split('\n')
        for word in words:
            word = word.strip().lower()
            if len(word) > 1: res.add(word)
        res.add('a')
        res.add('i')
        return res
    except:
        return set()

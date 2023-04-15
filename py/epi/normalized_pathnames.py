#!/usr/bin/env python3
#
# Description:
#
# Write a function to return the shortest version of a given path. Support
# absolute and relative paths.            

from rlib.testing_utils import expect

def normalized_pathnames(path):
    stk = []
    for token in path.split('/'):
        if token == '..':
            if len(stk) == 0 or stk[-1] == '..': stk.append(token)
            else: stk.pop()
        elif token not in {'.', ''}:
            stk.append(token)
    res = '/' if path[0] == '/' else ''
    res += '/'.join(stk)
    return res

def small_test():
    expect(normalized_pathnames('123/456')).to_be('123/456')
    expect(normalized_pathnames('/123/456')).to_be('/123/456')
    expect(normalized_pathnames('usr/lib/../bin/gcc')).to_be('usr/bin/gcc')
    expect(normalized_pathnames('./../')).to_be('..')
    expect(normalized_pathnames('../../local')).to_be('../../local')
    expect(normalized_pathnames('./.././../local')).to_be('../../local')
    expect(normalized_pathnames('/foo/../foo/./../')).to_be('/')

if __name__ == '__main__':
    small_test()

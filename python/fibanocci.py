#!/usr/bin/python

def fib_recursive(n):
    if n == 0: return 0
    if n == 1: return 1
    return fib_recursive(n - 1) + fib_recursive(n - 2)


def simple_test():
    stimulus = [
        (0, 0),
        (1, 1),
        (2, 1),
        (3, 2),
        (4, 3),
        (5, 5)
    ]
    for stm, exp in stimulus:
        assert(fib_recursive(stm) == exp)

if __name__ == '__main__':
    simple_test()
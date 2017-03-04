#!/usr/bin/python

def fib_recursive(n):
    if n == 0: return 0
    if n == 1: return 1
    return fib_recursive(n - 1) + fib_recursive(n - 2)


def simple_test():
    assert(fib_recursive(0) == 0)
    assert(fib_recursive(1) == 1)
    assert(fib_recursive(2) == 1)
    assert(fib_recursive(3) == 2)
    assert(fib_recursive(4) == 3)
    assert(fib_recursive(5) == 5)

if __name__ == '__main__':
    simple_test()
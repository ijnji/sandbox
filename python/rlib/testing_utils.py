#!/usr/bin/env python3

class Expectation():

    def __init__(self, result):
        self.result = result

    def to_be(self, reference):
        if self.result != reference:
            print('Expected "%s" to be "%s".' % (self.result, reference))

    def to_not_be(self, reference):
        if self.result == reference:
            print('Expected "%s" to not be "%s".' % (self.result, reference))

    def to_pass(self, checker, *args):
        if not checker(self.result, args):
            print('Expected "%s" to pass "%s".' % (self.result, checker))

def expect(result):
    return Expectation(result)

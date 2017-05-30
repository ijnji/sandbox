#!/usr/bin/python

class Expectation():

    def __init__(self, result):
        self.result = result

    def to_be(self, reference):
        if self.result != reference:
            print 'Expected %s to be %s.' % (self.result, reference)

    def to_not_be(self, reference):
        if self.result == reference:
            print 'Expected %s to not be %s.' % (self.result, reference)

def expect(result):
    return Expectation(result)

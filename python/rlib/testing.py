#!/usr/bin/python

def expect(target, reference):
    try:
        assert(target == reference)
    except:
        print 'Expected "%s" was "%s".' % (str(target), str(reference))

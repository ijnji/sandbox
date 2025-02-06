#!/usr/bin/env python3
#
# Description:
#
# Reverse a sublist of a linked-list given the head and a zero-based, inclusive,
# start and end integer boundary.

from rlib.linked_list_node import LinkedListNode
from rlib.list_utils import buildSingleList
from rlib.list_utils import draw
from rlib.testing_utils import expect

def reverseSublist(head, start, end):
    if end - start < 1 or head is None: return head
    dummy = LinkedListNode(0, head)
    prv = dummy
    cur = head
    counter = 0
    while counter < start:
        cur = cur.next
        prv = prv.next
        counter += 1
    subp = prv
    subh = cur
    nxt = cur.next
    while counter < end and nxt is not None:
        tmp = nxt.next
        nxt.next = cur
        subp.next = nxt
        subh.next = tmp
        cur = nxt
        nxt = tmp
        counter += 1
    return dummy.next

def check(headA, headB):
    if headA is None and headB is None: return True
    while headA and headB:
        if headA.data != headB.data: return False
        headA, headB = headA.next, headB.next
    if headA is None and headB is None: return True
    else: return False

def small_test():
    head = buildSingleList([1, 2, 3, 4, 5])
    result = reverseSublist(head, 0, 0)
    expected = buildSingleList([1, 2, 3, 4, 5])
    expect(check(result, expected)).to_be(True)
    head = buildSingleList([1, 2, 3, 4, 5])
    result = reverseSublist(head, 1, 3)
    expected = buildSingleList([1, 4, 3, 2, 5])
    expect(check(result, expected)).to_be(True)
    head = buildSingleList([1, 2, 3, 4, 5])
    result = reverseSublist(head, 0, 4)
    expected = buildSingleList([5, 4, 3, 2, 1])
    expect(check(result, expected)).to_be(True)

if __name__ == '__main__':
    small_test()

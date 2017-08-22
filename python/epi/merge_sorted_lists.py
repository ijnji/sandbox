#!/usr/bin/env python3
#
# Description:
#
# Merge two sorted lists.

from rlib.linked_list_node import LinkedListNode
from rlib.testing_utils import expect

def merge_sorted_lists(L1, L2):
    dummy = tail = LinkedListNode()
    while L1 and L2:
        if L1.data < L2.data:
            tail.next = L1
            L1 = L1.next
        else:
            tail.next = L2
            L2 = L2.next
        tail = tail.next
    if L1: tail.next = L1
    else: tail.next = L2
    return dummy.next

def small_test():
    L1, L2 = None, None
    L = merge_sorted_lists(L1, L2)
    expect(L).to_be(None)
    L1 = LinkedListNode(123)
    L = merge_sorted_lists(L1, L2)
    expect(L.data).to_be(123)
    expect(L.next).to_be(None)
    L2 = LinkedListNode(123)
    L1 = None
    L = merge_sorted_lists(L1, L2)
    expect(L.data).to_be(123)
    expect(L.next).to_be(None)
    L1 = LinkedListNode(-123)
    L2 = LinkedListNode(123)
    L = merge_sorted_lists(L1, L2)
    expect(L.data).to_be(-123)
    expect(L.next.data).to_be(123)
    expect(L.next.next).to_be(None)

if __name__ == '__main__':
    small_test()

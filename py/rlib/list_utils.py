#!/usr/bin/env python3

from rlib.linked_list_node import LinkedListNode

def buildSingleList(datas):
    dummy = LinkedListNode()
    curr = dummy
    for d in datas:
        curr.next = LinkedListNode(d)
        curr = curr.next
    return dummy.next

def draw(head):
    res = []
    while head is not None:
        res.append(str(head.data))
        head = head.next
    print(' '.join(res))

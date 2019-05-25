// Description:
//
// Cyclically rotate a linked-list right by n.

package moe.ijnji.epi;

import moe.ijnji.rlib.LinkedListNode;


public class CyclicRightShift {

    public static LinkedListNode<Integer> cyclicRightShift(
    LinkedListNode<Integer> head, int magnitude) {
        if (head == null) return null;
        int lng = 1;
        LinkedListNode<Integer> curr = head;
        while (curr.next != null) {
            curr = curr.next;
            lng++;
        }
        LinkedListNode<Integer> tail = curr;
        if (magnitude % lng == 0) return head;
        int off = lng - (magnitude % lng);
        curr = head;
        while (--off > 0) {
            curr = curr.next;
        }
        LinkedListNode<Integer> tmp = curr.next;
        tail.next = head;
        curr.next = null;
        return tmp;
    }

}

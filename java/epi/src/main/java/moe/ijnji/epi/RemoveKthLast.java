// Description:
//
// Remove a node from a linked-list when only given the target. Assume the
// target is never the tail.

package moe.ijnji.epi;

import moe.ijnji.rlib.LinkedListNode;


public class RemoveKthLast {

    public static LinkedListNode<Integer> removeKthLast(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> dummy = new LinkedListNode<>(0, head);
        LinkedListNode<Integer> front, back, backp;
        front = head;
        back = head;
        backp = dummy;
        while (k-- > 0 && front != null) front = front.next;
        if (front == null) return head;
        while (front.next != null) {
            front = front.next;
            back = back.next;
            backp = backp.next;
        }
        backp.next = back.next;
        return dummy.next;
    }

}

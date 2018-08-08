// Description:
//
// Check a linked-list for a cycle.

package moe.ijnji.epi;

import moe.ijnji.rlib.LinkedListNode;

public class CheckCycle {

    public static boolean checkCycle(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

}

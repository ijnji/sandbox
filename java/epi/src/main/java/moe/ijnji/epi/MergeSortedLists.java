// Description:
//
// Merge two sorted linked lists into a single sorted list.

package moe.ijnji.epi;

import moe.ijnji.rlib.LinkedListNode;

public class MergeSortedLists {

    public static LinkedListNode<Integer> mergeTwoLists(LinkedListNode<Integer> headA, LinkedListNode<Integer> headB) {
        LinkedListNode<Integer> dummy = new LinkedListNode<>();
        LinkedListNode<Integer> curr = dummy;

        while(headA != null && headB != null) {
            if (headA.data < headB.data) {
                curr.next = headA;
                headA = headA.next;
            } else {
                curr.next = headB;
                headB = headB.next;
            }
            curr = curr.next;
        }

        curr.next = (headA == null) ? headB : headA;
        return dummy.next;
    }

}

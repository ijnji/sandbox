// Description:
//
// Reverse a sublist of a linked-list given a starting and ending position, inclusive.

package moe.ijnji.epi;

import moe.ijnji.rlib.LinkedListNode;

public class ReverseSublist {

    public static LinkedListNode<Integer> reverse(
        LinkedListNode<Integer> head, int start, int end)
    {
        LinkedListNode<Integer> dummy = new LinkedListNode<>(null, head);
        LinkedListNode<Integer> subp = dummy;
        int counter = 0;
        while (counter < start) {
            subp = subp.next;
            counter++;
        }
        LinkedListNode<Integer> curr = subp.next;
        while (start < end) {
            LinkedListNode<Integer> temp = curr.next;
            curr.next = temp.next;
            temp.next = subp.next;
            subp.next = temp;
            start++;
        }
        return dummy.next;
    }

}

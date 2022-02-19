// Description:
//
// Remove all additional duplicate data in a linked-list.

package moe.ijnji.epi;

import moe.ijnji.rjlib.LinkedListNode;


public class RemoveDuplicates {

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> dummy = new LinkedListNode<>(0, head);
        LinkedListNode<Integer> curr = head;
        while (curr.next != null) {
            if (curr.next.data == curr.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

}

// Description:
//
// Remove a node from a linked-list when only given the target. Assume the
// target is never the tail.

package moe.ijnji.epi;

import moe.ijnji.rjlib.LinkedListNode;


public class RemoveFromSingle {

    public static void removeFromSingle(LinkedListNode<Integer> target) {
        target.data = target.next.data;
        target.next = target.next.next;
    }

}

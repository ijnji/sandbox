// Description:
//
// Given two cycle-free linked-lists, return the first node they have in common
// if they share nodes, otherwise return null.

package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rjlib.ListUtils;
import moe.ijnji.rjlib.LinkedListNode;

public class CheckOverlap {

    public static LinkedListNode<Integer> checkOverlap(
        LinkedListNode<Integer> headA, LinkedListNode<Integer> headB)
    {
        if (headA == null || headB == null) return null;
        LinkedListNode<Integer> currA = headA;
        int lenA = 0;
        while (currA != null) {
            currA = currA.next;
            lenA++;
        }
        int lenB = 0;
        LinkedListNode<Integer> currB = headB;
        while (currB != null) {
            currB = currB.next;
            lenB++;
        }
        currA = headA;
        currB = headB;
        while (lenA > lenB) {
            currA = currA.next;
            lenA--;
        }
        while (lenB > lenA) {
            currB = currB.next;
            lenB--;
        }
        while (currA != null && currB != null) {
            if (currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

}

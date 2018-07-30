// Description:
//
// Given two cycle-free linked-lists, return the first node they have in common
// if they share nodes, otherwise return null.

package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.ListUtils;
import moe.ijnji.rlib.LinkedListNode;

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

  private static void smallTest() {
    LinkedListNode<Integer> headA, headB;

    // 1--2--3--4--5
    // 1-/
    headA = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    headB = ListUtils.buildSingleList(Arrays.asList(1));
    headB.next = headA.next;
//expect(checkOverlap(headA, headB)).toBe(headB.next);

    // 1--2--3--4--5
    //    2--3-/
    headA = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    headB = ListUtils.buildSingleList(Arrays.asList(2, 3));
    headB.next.next = headA.next.next.next;
//expect(checkOverlap(headA, headB)).toBe(headB.next.next);

    // 1--2--3--4--5
    // 1--2--3--4--5
    headA = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    headB = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
//expect(checkOverlap(headA, headB)).toBe(null);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

// Description:
//
// Merge two sorted linked lists into a single sorted list.

package epi;

import java.util.Arrays;
import java.util.List;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

public class MergeSortedLists {

  private static LinkedListNode<Integer> mergeTwoLists(
    LinkedListNode<Integer> headA, LinkedListNode<Integer> headB)
  {
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

  private static boolean check(
    LinkedListNode<Integer> head1, LinkedListNode<Integer> head2)
  {
    while (head1 != null || head2 != null) {
      if (head1.data != head2.data) return false;
      head1 = head1.next;
      head2 = head2.next;
    }
    if (head1 == null && head2 == null) return true;
    else return false;
  }

  private static void smallTest() {
    LinkedListNode<Integer> headA, headB, result, expected;

    headA = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    headB = ListUtils.buildSingleList(Arrays.asList(6, 7, 8, 9, 10));
    result = mergeTwoLists(headA, headB);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    expect(check(result, expected)).toBe(true);

    headA = ListUtils.buildSingleList(Arrays.asList(2, 4, 6, 8, 10));
    headB = ListUtils.buildSingleList(Arrays.asList(1, 3, 5, 7, 9));
    result = mergeTwoLists(headA, headB);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  public static void main(String[] args) {
    smallTest();
  }

}

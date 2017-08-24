// Description:
//
// Remove a node from a linked-list when only given the target. Assume the
// target is never the tail.

package epi;

import java.util.Arrays;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

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

  private static boolean check(
    LinkedListNode<Integer> head1, LinkedListNode<Integer> head2)
  {
    while (head1 != null && head2 != null) {
      if (head1.data != head2.data) return false;
      head1 = head1.next;
      head2 = head2.next;
    }
    if (head1 == null && head2 == null) return true;
    else return false;
  }

  private static void smallTest() {
    LinkedListNode<Integer> head, expected;

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
    head = removeKthLast(head, 1);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 3));
    expect(check(head, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
    head = removeKthLast(head, 0);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 2));
    expect(check(head, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
    head = removeKthLast(head, 2);
    expected = ListUtils.buildSingleList(Arrays.asList(2, 3));
    expect(check(head, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

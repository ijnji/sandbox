// Description:
//
// Remove a node from a linked-list when only given the target. Assume the
// target is never the tail.

package epi;

import java.util.Arrays;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

public class RemoveFromSingle {

  public static void removeFromSingle(LinkedListNode<Integer> target) {
    target.data = target.next.data;
    target.next = target.next.next;
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
    LinkedListNode<Integer> head, expected;

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
    removeFromSingle(head.next);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 3));
    expect(check(head, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

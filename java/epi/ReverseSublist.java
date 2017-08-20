// Description:
//
// Reverse a sublist of a linked-list given a starting and ending position, inclusive.

package epi;

import java.util.Arrays;
import java.util.List;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

public class ReverseSublist {

  public static LinkedListNode<Integer> reverseSublist(
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
    LinkedListNode<Integer> head, result, expected;

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    result = reverseSublist(head, 1, 8);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 9, 8, 7, 6, 5, 4, 3, 2, 10));
    expect(check(result, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1));
    result = reverseSublist(head, 0, 0);
    expected = ListUtils.buildSingleList(Arrays.asList(1));
    expect(check(result, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2));
    result = reverseSublist(head, 0, 1);
    expected = ListUtils.buildSingleList(Arrays.asList(2, 1));
    expect(check(result, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2));
    result = reverseSublist(head, 1, 1);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 2));
    expect(check(result, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

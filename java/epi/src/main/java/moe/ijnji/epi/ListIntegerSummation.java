// Description:
//
// Given two linked-lists that represent an integer with each node a digit, and
// the least significant digit at the head, return the summation of the integers
// in the same format.

package epi;

import java.util.Arrays;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

public class ListIntegerSummation {

  public static LinkedListNode<Integer> listIntegerSummation(
    LinkedListNode<Integer> head1, LinkedListNode<Integer> head2)
  {
    LinkedListNode<Integer> dummy = new LinkedListNode<>();
    LinkedListNode<Integer> curr = dummy;
    int c = 0;
    while (head1 != null || head2 != null) {
      int a = (head1 != null) ? head1.data : 0;
      int b = (head2 != null) ? head2.data : 0;
      int sum = a + b + c;
      curr.next = new LinkedListNode<>(sum % 10);
      curr = curr.next;
      c = (sum >= 10) ? 1 : 0;
      head1 = head1.next;
      head2 = head2.next;
    }
    if (c > 0) curr.next = new LinkedListNode<>(1);
    return dummy.next;
  }

  private static void smallTest() {
    LinkedListNode<Integer> head1, head2, result, expected;

    head1 = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
    head2 = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
    result = listIntegerSummation(head1, head2);
    expected = ListUtils.buildSingleList(Arrays.asList(2, 4, 6));
    expect(ListUtils.equivalence(result, expected)).toBe(true);

    head1 = ListUtils.buildSingleList(Arrays.asList(3, 2, 8));
    head2 = ListUtils.buildSingleList(Arrays.asList(9, 7, 7));
    result = listIntegerSummation(head1, head2);
    expected = ListUtils.buildSingleList(Arrays.asList(2, 0, 6, 1));
    expect(ListUtils.equivalence(result, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

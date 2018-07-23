// Description:
//
// Rearrange a linked-list such that the evenly positioned elements come first,
// then the oddly positioned elements. For example, 0-1-2-3-4-5-6 becomes,
// 0-2-4-6-1-3-5

package epi;

import java.util.Arrays;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

public class MergeEvenOdd {

  public static LinkedListNode<Integer> mergeEvenOdd(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> even = new LinkedListNode<Integer>(9);
    LinkedListNode<Integer> evenCurr = even;
    LinkedListNode<Integer> odd = new LinkedListNode<Integer>(9);
    LinkedListNode<Integer> oddCurr = odd;
    boolean isEven = true;
    LinkedListNode<Integer> curr = head;
    while (curr != null) {
      if (isEven) {
        evenCurr.next = curr;
        evenCurr = evenCurr.next;
      } else {
        oddCurr.next = curr;
        oddCurr = oddCurr.next;
      }
      curr = curr.next;
      isEven = !isEven;
    }
    evenCurr.next = odd.next;
    oddCurr.next = null;
    return even.next;
  }

  private static void smallTest() {
    LinkedListNode<Integer> head, expected;

    head = ListUtils.buildSingleList(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
    head = mergeEvenOdd(head);
    expected = ListUtils.buildSingleList(Arrays.asList(0, 2, 4, 6, 1, 3, 5));
    expect(ListUtils.equivalence(head, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(0, 1));
    head = mergeEvenOdd(head);
    expected = ListUtils.buildSingleList(Arrays.asList(0, 1));
    expect(ListUtils.equivalence(head, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(0));
    head = mergeEvenOdd(head);
    expected = ListUtils.buildSingleList(Arrays.asList(0));
    expect(ListUtils.equivalence(head, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

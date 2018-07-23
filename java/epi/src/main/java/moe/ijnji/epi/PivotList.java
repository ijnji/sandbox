// Description:
//
// Pivot a linked-list. Given a list, and a value, rearrange the elements such
// that elements less than the value come first, then elements equal to the
// value, then elements greater than the value come last.

package epi;

import java.util.Arrays;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

public class PivotList {

  public static LinkedListNode<Integer> pivotList(LinkedListNode<Integer> head, int value) {
    LinkedListNode<Integer> ls = new LinkedListNode<>();
    LinkedListNode<Integer> eq = new LinkedListNode<>();
    LinkedListNode<Integer> gr = new LinkedListNode<>();
    LinkedListNode<Integer> lsc = ls;
    LinkedListNode<Integer> eqc = eq;
    LinkedListNode<Integer> grc = gr;
    LinkedListNode<Integer> curr = head;
    while (curr != null) {
      if (curr.data < value) {
        lsc.next = curr;
        lsc = lsc.next;
      } else if (curr.data == value) {
        eqc.next = curr;
        eqc = eqc.next;
      } else {
        grc.next = curr;
        grc = grc.next;
      }
      curr = curr.next;
    }
    lsc.next = eq.next;
    eqc.next = gr.next;
    grc.next = null;
    return ls.next;
  }

  private static void smallTest() {
    LinkedListNode<Integer> head, result, expected;

    head = ListUtils.buildSingleList(Arrays.asList(1, 3, 2, 3, 1, 2));
    result = pivotList(head, 2);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 1, 2, 2, 3, 3));
    expect(ListUtils.equivalence(result, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 3, 2, 3, 1, 2));
    result = pivotList(head, 1);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 1, 3, 2, 3, 2));
    expect(ListUtils.equivalence(result, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 3, 2, 3, 1, 2));
    result = pivotList(head, 3);
    expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 1, 2, 3, 3));
    expect(ListUtils.equivalence(result, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

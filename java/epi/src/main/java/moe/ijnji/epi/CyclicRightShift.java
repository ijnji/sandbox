// Description:
//
// Cyclically rotate a linked-list right by n.

package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.ListUtils;
import moe.ijnji.rlib.LinkedListNode;


public class CyclicRightShift {

  public static LinkedListNode<Integer> cyclicRightShift(
    LinkedListNode<Integer> head, int magnitude)
  {
    if (head == null) return null;
    int lng = 1;
    LinkedListNode<Integer> curr = head;
    while (curr.next != null) {
      curr = curr.next;
      lng++;
    }
    LinkedListNode<Integer> tail = curr;
    if (magnitude % lng == 0) return head;
    int off = lng - (magnitude % lng);
    curr = head;
    while (--off > 0) {
      curr = curr.next;
    }
    LinkedListNode<Integer> tmp = curr.next;
    tail.next = head;
    curr.next = null;
    return tmp;
  }

  private static void smallTest() {
    LinkedListNode<Integer> head;

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    head = cyclicRightShift(head, 2);
    //expected = ListUtils.buildSingleList(Arrays.asList(4, 5, 1, 2, 3));
    //expect(ListUtils.equivalence(head, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    head = cyclicRightShift(head, 0);
    //expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    //expect(ListUtils.equivalence(head, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    head = cyclicRightShift(head, 10);
    //expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    //expect(ListUtils.equivalence(head, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    head = cyclicRightShift(head, 9);
    //expected = ListUtils.buildSingleList(Arrays.asList(2, 3, 4, 5, 1));
    //expect(ListUtils.equivalence(head, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

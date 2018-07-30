// Description:
//
// Remove all additional duplicate data in a linked-list.

package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.ListUtils;
import moe.ijnji.rlib.LinkedListNode;


public class RemoveDuplicates {

  public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> dummy = new LinkedListNode<>(0, head);
    LinkedListNode<Integer> curr = head;
    while (curr.next != null) {
      if (curr.next.data == curr.data) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }
    return dummy.next;
  }

  private static void smallTest() {
    LinkedListNode<Integer> head;

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 2, 2, 3, 3, 4));
    head = removeDuplicates(head);
    //expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4));
    //expect(ListUtils.equivalence(head, expected)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 1));
    head = removeDuplicates(head);
    //expected = ListUtils.buildSingleList(Arrays.asList(1));
    //expect(ListUtils.equivalence(head, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

// Description:
//
// Check a linked-list for a cycle.

package epi;

import java.util.Arrays;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

public class CheckCycle {

  private static boolean checkCycle(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> slow = head;
    LinkedListNode<Integer> fast = head;
    while (slow != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }

  private static void smallTest() {
    LinkedListNode<Integer> five = new LinkedListNode<>(5);
    LinkedListNode<Integer> four = new LinkedListNode<>(4, five);
    LinkedListNode<Integer> three = new LinkedListNode<>(3, four);
    LinkedListNode<Integer> two = new LinkedListNode<>(2, three);
    LinkedListNode<Integer> one = new LinkedListNode<>(1, two);
    expect(checkCycle(one)).toBe(false);
    four.next = two;
    expect(checkCycle(one)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

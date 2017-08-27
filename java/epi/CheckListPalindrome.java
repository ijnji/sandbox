// Description:
//
// Check whether a singlely linked linked-list is palindromic.

package epi;

import java.util.Arrays;
import rlib.ListUtils;
import rlib.LinkedListNode;
import static rlib.TestingUtils.expect;

public class CheckListPalindrome {

  public static boolean checkListPalindrome(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> half = head, tail = head;
    while (tail.next != null) {
      if (tail.next.next == null) {
        tail = tail.next;
      } else {
        tail = tail.next.next;
      }
      half = half.next;
    }
    if (half == tail) return (head.data == tail.data);
    reverse(half.next, half, tail);
    LinkedListNode<Integer> front = head, back = tail;
    while (back != half) {
      if (front.data != back.data) {
        reverse(tail, null, half.next);
        return false;
      }
      front = front.next;
      back = back.next;
    }
    reverse(tail, null, half.next);
    return true;
  }

  private static void reverse(
    LinkedListNode<Integer> head, LinkedListNode<Integer> prev, LinkedListNode<Integer> end)
  {
    while (prev != end) {
      LinkedListNode<Integer> tmp = head.next;
      head.next = prev;
      prev = head;
      head = tmp;
    }
  }

  private static void smallTest() {
    LinkedListNode<Integer> head;

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
    expect(checkListPalindrome(head)).toBe(false);

    head = ListUtils.buildSingleList(Arrays.asList(3, 2, 1, 2, 3));
    expect(checkListPalindrome(head)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5, 6));
    expect(checkListPalindrome(head)).toBe(false);

    head = ListUtils.buildSingleList(Arrays.asList(3, 2, 1, 1, 2, 3));
    expect(checkListPalindrome(head)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1, 2));
    expect(checkListPalindrome(head)).toBe(false);

    head = ListUtils.buildSingleList(Arrays.asList(1, 1));
    expect(checkListPalindrome(head)).toBe(true);

    head = ListUtils.buildSingleList(Arrays.asList(1));
    expect(checkListPalindrome(head)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

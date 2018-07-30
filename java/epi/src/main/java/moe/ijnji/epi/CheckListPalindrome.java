// Description:
//
// Check whether a singlely linked linked-list is palindromic.

package moe.ijnji.epi;

import java.util.Arrays;
import java.util.List;
import moe.ijnji.rlib.ListUtils;
import moe.ijnji.rlib.LinkedListNode;


public class CheckListPalindrome {

  public static boolean checkListPalindrome(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> half = head, tail = head;
    while (tail != null && tail.next != null) {
      half = half.next;
      tail = tail.next.next;
    }
    LinkedListNode<Integer> front = head, back = reverse(half);
    tail = back; // For restoration
    boolean isPalindrome = true;
    while (front != null && back != null) {
      if (front.data != back.data) {
        isPalindrome = false;
        break;
      }
      front = front.next;
      back = back.next;
    }
    half = reverse(tail);
    return isPalindrome;
  }

  private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> prev = null;
    while (head != null) {
      LinkedListNode<Integer> tmp = head.next;
      head.next = prev;
      prev = head;
      head = tmp;
    }
    return prev;
  }

  private static void smallTest() {
    List<Integer> stim;
    LinkedListNode<Integer> head;

    stim = Arrays.asList(1, 2, 3, 4, 5);
    head = ListUtils.buildSingleList(stim);
    //expect(checkListPalindrome(head)).toBe(false);
    //expect(ListUtils.equivalence(head, ListUtils.buildSingleList(stim))).toBe(true);

    stim = Arrays.asList(3, 2, 1, 2, 3);
    head = ListUtils.buildSingleList(stim);
    //expect(checkListPalindrome(head)).toBe(true);
    //expect(ListUtils.equivalence(head, ListUtils.buildSingleList(stim))).toBe(true);

    stim = Arrays.asList(1, 2, 3, 4, 5, 6);
    head = ListUtils.buildSingleList(stim);
    //expect(checkListPalindrome(head)).toBe(false);
    //expect(ListUtils.equivalence(head, ListUtils.buildSingleList(stim))).toBe(true);

    stim = Arrays.asList(3, 2, 1, 1, 2, 3);
    head = ListUtils.buildSingleList(stim);
    //expect(checkListPalindrome(head)).toBe(true);
    //expect(ListUtils.equivalence(head, ListUtils.buildSingleList(stim))).toBe(true);

    stim = Arrays.asList(1, 2);
    head = ListUtils.buildSingleList(stim);
    //expect(checkListPalindrome(head)).toBe(false);
    //expect(ListUtils.equivalence(head, ListUtils.buildSingleList(stim))).toBe(true);

    stim = Arrays.asList(1, 1);
    head = ListUtils.buildSingleList(stim);
    //expect(checkListPalindrome(head)).toBe(true);
    //expect(ListUtils.equivalence(head, ListUtils.buildSingleList(stim))).toBe(true);

    stim = Arrays.asList(1);
    head = ListUtils.buildSingleList(stim);
    //expect(checkListPalindrome(head)).toBe(true);
    //expect(ListUtils.equivalence(head, ListUtils.buildSingleList(stim))).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

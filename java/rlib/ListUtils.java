package rlib;

import java.util.List;
import rlib.Operatable;

public class ListUtils {

  public static <T> LinkedListNode<T> buildSingleList(List<T> datas) {
    LinkedListNode<T> dummy = new LinkedListNode<T>();
    LinkedListNode<T> curr = dummy;
    for (T d : datas) {
      curr.next = new LinkedListNode<T>(d);
      curr = curr.next;
    }
    return dummy.next;
  }

  public static <T> LinkedListNode<T> buildDoubleList(List<T> datas) {
    LinkedListNode<T> dummy = new LinkedListNode<T>();
    LinkedListNode<T> curr = dummy;
    for (T d : datas) {
      curr.next = new LinkedListNode<T>(d);
      curr.next.prev = curr;
      curr = curr.next;
    }
    return dummy.next;
  }

  public static <T> boolean equivalence(
    LinkedListNode<T> head1, LinkedListNode<T> head2)
  {
    while (head1 != null && head2 != null) {
      if (head1.data != head2.data) return false;
      head1 = head1.next;
      head2 = head2.next;
    }
    if (head1 == null && head2 == null) return true;
    else return false;
  }

  public static <T> void draw(LinkedListNode<T> head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }

}

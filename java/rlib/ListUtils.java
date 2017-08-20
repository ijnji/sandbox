package rlib;

import java.util.List;

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

  public static <T> void draw(LinkedListNode<T> head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }

}

package rlib;

public class LinkedListNode<T> {

  public T data = null;
  public LinkedListNode<T> next = null;
  public LinkedListNode<T> prev = null;

  public LinkedListNode() {}

  public LinkedListNode(T data) {
    this.data = data;
  }

  public LinkedListNode(
    T data,
    LinkedListNode<T> next)
  {
    this.data = data;
    this.next = next;
  }

  public LinkedListNode(
    T data,
    LinkedListNode<T> next,
    LinkedListNode<T> prev)
  {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }

}

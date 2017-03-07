package rlib;

public class BinaryTreeNode<T> {

  public T data = null;
  public BinaryTreeNode<T> left = null;
  public BinaryTreeNode<T> right = null;

  public BinaryTreeNode(T aData) {
    this.data = aData;
  }

  public String toString() {
    return this.data.toString();
  }
  
}


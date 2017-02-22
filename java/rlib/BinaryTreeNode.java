package rlib;

public class BinaryTreeNode<T> {
  private T data;
  private BinaryTreeNode<T> left;
  private BinaryTreeNode<T> right;

  public BinaryTreeNode<T>() {
    this.data = null;
    this.left = null;
    this.right = null;
  }

  public BinaryTreeNode<T>(T aData) {
    this.data = aData;
  }
}


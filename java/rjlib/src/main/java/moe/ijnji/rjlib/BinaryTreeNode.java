package moe.ijnji.rjlib;

public class BinaryTreeNode<T> {

    public T data = null;
    public BinaryTreeNode<T> left = null;
    public BinaryTreeNode<T> right = null;
    public BinaryTreeNode<T> parent = null;

    public BinaryTreeNode() {}

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right, BinaryTreeNode<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

}

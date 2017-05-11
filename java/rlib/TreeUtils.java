package rlib;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

public class TreeUtils {

  public static <T> BinaryTreeNode<T> buildTree(List<T> datas) {
    if (datas == null || datas.size() == 0) return null;
    BinaryTreeNode<T> root = new BinaryTreeNode<>(datas.get(0));
    Queue<BinaryTreeNode<T>> que = new LinkedList<>();
    que.add(root);
    int i = 1;
    while (i < datas.size()) {
      BinaryTreeNode<T> n = que.remove();
      n.left = new BinaryTreeNode<T>();
      n.left.data = (i < datas.size()) ? datas.get(i++) : null;
      n.right = new BinaryTreeNode<T>();
      n.right.data = (i < datas.size()) ? datas.get(i++) : null;
      que.add(n.left);
      que.add(n.right);
    }
    return trimTree(root);
  }

  private static <T> BinaryTreeNode<T> trimTree(BinaryTreeNode<T> root) {
    if (root == null || root.data == null) return null;
    Queue<BinaryTreeNode<T>> que = new LinkedList<>();
    que.add(root);
    while (que.size() > 0) {
      BinaryTreeNode<T> n = que.remove();
      if (n.left != null) {
        if (n.left.data == null) n.left = null;
        else que.add(n.left);
      }
      if (n.right != null) {
        if (n.right.data == null) n.right = null;
        else que.add(n.right);
      }
    }
    return root;
  }

  public static <T> BinaryTreeNode<T> buildTreeWithParent(List<T> datas) {
    return linkParents(buildTree(datas));
  }

  private static <T> BinaryTreeNode<T> linkParents(BinaryTreeNode<T> root) {
    Queue<BinaryTreeNode<T>> que = new LinkedList<>();
    que.add(root);
    while (que.size() > 0) {
      BinaryTreeNode<T> n = que.remove();
      if (n.left != null) {
        n.left.parent = n;
        que.add(n.left);
      }
      if (n.right != null) {
        n.right.parent = n;
        que.add(n.right);
      }
    }
    return root;
  }

}
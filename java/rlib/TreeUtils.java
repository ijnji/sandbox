package rlib;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

public class TreeUtils {

  public static <T> BinaryTreeNode<T> buildTree(List<T> datas) {
    if (datas == null || datas.size() == 0) return null;
    BinaryTreeNode<T> root = new BinaryTreeNode<>(datas.get(0));
    BinaryTreeNode<T> n = root;
    Queue<BinaryTreeNode<T>> que = new LinkedList<>();
    for (int i = 1; i < datas.size(); i++) {
      T dt = datas.get(i);
      if (n.left == null) {
        n.left = new BinaryTreeNode<T>(dt);
        que.add(n.left);
      } else {
        n.right = new BinaryTreeNode<T>(dt);
        que.add(n.right);
        n = que.remove();
      }
    }
    trimTree(root);
    return root;
  }

  public static <T> BinaryTreeNode<T> buildTreeWithParent(List<T> datas) {
    if (datas == null || datas.size() == 0) return null;
    BinaryTreeNode<T> root = buildTree(datas);
    return buildParents(root);
  }

  private static <T> void trimTree(BinaryTreeNode<T> root) {
    Stack<BinaryTreeNode<T>> stk = new Stack<>();
    stk.push(root);
    while (stk.size() > 0) {
      BinaryTreeNode<T> n = stk.pop();
      if (n.left != null) {
        if (n.left.data == null) n.left = null;
        else stk.push(n.left);
      }
      if (n.right != null) {
        if (n.right.data == null) n.right = null;
        else stk.push(n.right);
      }
    }
  }

  private static <T> void buildParents(BinaryTreeNode<T> root) {
    Stack<BinaryTreeNode<T>> stk = new Stack<>();
    stk.push(root);
    while (stk.size() > 0) {
      BinaryTreeNode<T> n = stk.pop();
      if (n.left != null) {
        n.left.parent = n;
        stk.push(n.left);
      }
      if (n.right != null) {
        n.right.parent = n;
        stk.push(n.right);
      }
    }
  }

}
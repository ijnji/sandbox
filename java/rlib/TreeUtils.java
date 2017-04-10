package rlib;

import java.util.LinkedList;
import java.util.List;
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
    return root;
  }

}
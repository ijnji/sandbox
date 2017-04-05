import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

import rlib.BinaryTreeNode;
import static rlib.TestingUtils.expect;

public class TreeTraversals {

  private static void inorderRecursive(BinaryTreeNode<Integer> root) {
    if (root == null) return;
    inorderRecursive(root.left);
    if (root.data != null) System.out.println(root.data);
    else System.out.println("null");
    inorderRecursive(root.right);
  }

  public static void main(String[] args) {
    //       3
    //     9   20
    //    n n 15 7
    // n, 9, n, 3, 15, 20, 7
    List<Integer> dts = Arrays.asList(3, 9, 20, null, null, 15, 7);
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(dts.get(0));
    Queue<BinaryTreeNode<Integer>> que = new LinkedList<>();
    BinaryTreeNode<Integer> n = root;
    for (int i = 1; i < dts.size(); i++) {
      if (n.left == null) {
        n.left = new BinaryTreeNode<>(dts.get(i));
        que.add(n.left);
      } else {
        n.right = new BinaryTreeNode<>(dts.get(i));
        que.add(n.right);
        n = que.remove();
      }
    }

    inorderRecursive(root);
  }
  
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import rlib.BinaryTreeNode;
import rlib.TreeUtils;
import static rlib.TestingUtils.expect;

public class TreeTraversals {

  private static void inorderRecursive(BinaryTreeNode<Integer> root, List<Integer> result) {
    if (root == null) return;
    inorderRecursive(root.left, result);
    result.add(root.data);
    inorderRecursive(root.right, result);
  }

  private static void preorderRecursive(BinaryTreeNode<Integer> root, List<Integer> result) {
    if (root == null) return;
    result.add(root.data);
    preorderRecursive(root.left, result);
    preorderRecursive(root.right, result);
  }

  private static void postorderRecursive(BinaryTreeNode<Integer> root, List<Integer> result) {
    if (root == null) return;
    postorderRecursive(root.left, result);
    postorderRecursive(root.right, result);
    result.add(root.data);
  }

  public static void main(String[] args) {
    // 3
    //  |--20
    //  |   |--7
    //  |   |--15
    //  |--9
    //      |--n
    //      |--n

    BinaryTreeNode<Integer> root = TreeUtils.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
    List<Integer> res;
    res = new ArrayList<Integer>();
    inorderRecursive(root, res);
    expect(res).toBe(Arrays.asList(null, 9, null, 3, 15, 20, 7));
    res = new ArrayList<Integer>();
    preorderRecursive(root, res);
    expect(res).toBe(Arrays.asList(3, 9, null, null, 20, 15, 7));
    res = new ArrayList<Integer>();
    postorderRecursive(root, res);
    expect(res).toBe(Arrays.asList(null, null, 9, 15, 7, 20, 3));
  }
  
}
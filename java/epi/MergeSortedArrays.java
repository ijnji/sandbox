// Description:
//
// Given a set of sorted lists of transactions as tuples with the following:
// {timestamp, id, payload

package epi;

import java.util.Arrays;
import rlib.BinaryTreeNode;
import rlib.TreeUtils;
import static rlib.TestingUtils.expect;

public class SumRootToLeafBinaryTree {

  private static int sumRecurse(BinaryTreeNode<Integer> root, int partial) {
    if (root == null) return 0;
    int p = (partial << 1) + root.data;
    if (root.left == null && root.right == null) return p;
    else return sumRecurse(root.left, p) + sumRecurse(root.right, p);
  }

  public static int SumRootToLeafBinaryTree(BinaryTreeNode<Integer> root) {
    return sumRecurse(root, 0);
  }

  private static void smallTest() {
    BinaryTreeNode<Integer> root;
    root = TreeUtils.buildTree(Arrays.asList(1));
    expect(SumRootToLeafBinaryTree(root)).toBe(1);
    root = TreeUtils.buildTree(Arrays.asList(1, 0, 1));
    expect(SumRootToLeafBinaryTree(root)).toBe(5);
    root = TreeUtils.buildTree(Arrays.asList(
        1, 
        0, 1,
        0, 1, 0, 0,
        0, 1, null, null, null, 0, null, 0
    ));
    expect(SumRootToLeafBinaryTree(root)).toBe(46);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
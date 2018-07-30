// Description:
//
// Given a binary tree where each node represents a single bit of a binary
// number (MSB at root, LSB at leaf), find the sum of all binary numbers in the
// tree.

package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.BinaryTreeNode;
import moe.ijnji.rlib.TreeUtils;


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
    //expect(SumRootToLeafBinaryTree(root)).toBe(1);
    root = TreeUtils.buildTree(Arrays.asList(1, 0, 1));
    //expect(SumRootToLeafBinaryTree(root)).toBe(5);
    root = TreeUtils.buildTree(Arrays.asList(
        1, 
        0, 1,
        0, 1, 0, 0,
        0, 1, null, null, null, 0, null, 0
    ));
    //expect(SumRootToLeafBinaryTree(root)).toBe(46);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
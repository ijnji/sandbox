// Description:
//
// Check if a binary tree is symmetric.

package moe.ijnji.epi;

import java.lang.Math;
import java.util.Arrays;
import moe.ijnji.rjlib.BinaryTreeNode;
import moe.ijnji.rjlib.TreeUtils;


public class SymmetricBinaryTree {

  private static boolean checkSubtrees(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
    if (left == null && right == null) {
      return true;
    } else if (left != null && right != null) {
      return (left.data == right.data) &&
        checkSubtrees(left.left, right.right) &&
        checkSubtrees(left.right, right.left);
    } else {
      return false;
    }
  }

  public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
    return (root == null) || checkSubtrees(root.left, root.right);
  }

  private static void smallTest() {
    BinaryTreeNode<Integer> root;
    root = TreeUtils.buildTree(Arrays.asList(1));
    //expect(isSymmetric(root)).toBe(true);
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 3));
    //expect(isSymmetric(root)).toBe(false);
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 2, 3, 4, 4, 3));
    //expect(isSymmetric(root)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
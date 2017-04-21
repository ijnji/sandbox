// Description:
//
// Check if a binary tree is height balanced.

package epi;

import java.lang.Math;
import java.util.Arrays;
import rlib.BinaryTreeNode;
import rlib.TreeUtils;
import static rlib.TestingUtils.expect;

public class BalancedBinaryTree {

  public static boolean isBalanced(BinaryTreeNode<Integer> root) {
    if (root == null) return true;
    int maxh = Math.max(maxHeight(root.left, 1), maxHeight(root.right, 1));
    int minh = Math.min(minHeight(root.left, 1), minHeight(root.right, 1));
    System.out.print(minh + " " + maxh);
    System.out.println();
    if (Math.abs(maxh - minh) > 1) return false;
    else return true;
  }

  private static int maxHeight(BinaryTreeNode<Integer> root, int height) {
    if (root == null) return height - 1;
    return Math.max(maxHeight(root.left, height + 1), maxHeight(root.right, height + 1));
  }

  private static int minHeight(BinaryTreeNode<Integer> root, int height) {
    if (root == null) return height - 1;
    return Math.min(minHeight(root.left, height + 1), minHeight(root.right, height + 1));
  }

  private static void inorder(BinaryTreeNode<Integer> root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  private static void smallTest() {
    BinaryTreeNode<Integer> root;
    root = TreeUtils.buildTree(Arrays.asList(1));
    expect(isBalanced(root)).toBe(true);
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 3));
    expect(isBalanced(root)).toBe(true);
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    expect(isBalanced(root)).toBe(true);
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 3, null, null, 6, 7));
    expect(isBalanced(root)).toBe(true);
    root = TreeUtils.buildTree(Arrays.asList(1, null, 3, null, null, null, 7));
    expect(isBalanced(root)).toBe(false);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
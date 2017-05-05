// Description:
//
// Find the lowest common ancestors between two nodes in a binary tree.

package epi;

import java.lang.Math;
import java.util.Arrays;
import rlib.BinaryTreeNode;
import rlib.TreeUtils;
import static rlib.TestingUtils.expect;

public class LowestCommonAncestorWithParent {

  public static int findHeight(BinaryTreeNode<Integer> root) {
    if (root == null) return -1;
    int h = 0;
    while (root != null) {
      
    }
  }

  public static BinaryTreeNode<Integer> LowestCommonAncestorWithParent(
    BinaryTreeNode<Integer> na,
    BinaryTreeNode<Integer> nb)
  {

  }

  private static void smallTest() {
    BinaryTreeNode<Integer> root, lca, na, nb;
    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3));
    na = root.left;
    nb = root.right;
    expect(LowestCommonAncestorWithParent(root, na, nb)).toBe(lca);
    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    na = root.left.left;
    nb = root.left.right;
    expect(LowestCommonAncestorWithParent(root, na, nb)).toBe(lca);
    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    na = root.right.left;
    nb = root.right.right;
    expect(LowestCommonAncestorWithParent(root, na, nb)).toBe(lca);
    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    na = root.left.right;
    nb = root.right.left;
    expect(LowestCommonAncestor(root, na, nb)).toBe(lca);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
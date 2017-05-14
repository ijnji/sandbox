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
    int h = -1;
    while (root != null) {
      h++;
      root = root.parent;
    }
    return h;
  }

  public static BinaryTreeNode<Integer> LowestCommonAncestorWithParent(
    BinaryTreeNode<Integer> na,
    BinaryTreeNode<Integer> nb)
  {
    if (na == null || nb == null) return null;
    int ha = findHeight(na);
    int hb = findHeight(nb);
    while (ha > hb) {
      na = na.parent;
      ha--;
    }
    while (hb > ha) {
      nb = nb.parent;
      hb--;
    }
    while (na != nb) {
      na = na.parent;
      nb = nb.parent;
    }
    return na;
  }

  private static void smallTest() {
    BinaryTreeNode<Integer> root, lca, na, nb;
    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3));
    lca = root;
    na = root.left;
    nb = root.right;
    expect(LowestCommonAncestorWithParent(na, nb)).toBe(lca);
    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    lca = root.left;
    na = root.left.left;
    nb = root.left.right;
    expect(LowestCommonAncestorWithParent(na, nb)).toBe(lca);
    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    lca = root.right;
    na = root.right.left;
    nb = root.right.right;
    expect(LowestCommonAncestorWithParent(na, nb)).toBe(lca);
    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    lca = root;
    na = root.left.right;
    nb = root.right.left;
    expect(LowestCommonAncestorWithParent(na, nb)).toBe(lca);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
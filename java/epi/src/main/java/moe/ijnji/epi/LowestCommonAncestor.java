// Description:
//
// Find the lowest common ancestors between two nodes in a binary tree.

package moe.ijnji.epi;

import java.lang.Math;
import java.util.Arrays;
import moe.ijnji.rlib.BinaryTreeNode;
import moe.ijnji.rlib.TreeUtils;

public class LowestCommonAncestor {

  private static class Status {
    public int count;
    public BinaryTreeNode<Integer> ancestor;
    public Status(int count, BinaryTreeNode<Integer> ancestor) {
      this.count = count;
      this.ancestor = ancestor;
    }
  }

  private static Status LCARecurse(
    BinaryTreeNode<Integer> root,
    BinaryTreeNode<Integer> na,
    BinaryTreeNode<Integer> nb)
  {
    if (root == null) return new Status(0, null);
    Status ls = LCARecurse(root.left, na, nb);
    Status rs = LCARecurse(root.right, na, nb);
    if (ls.count == 2) return ls;
    if (rs.count == 2) return rs;
    int cnt = ls.count + rs.count + (na == root ? 1 : 0) + (nb == root ? 1: 0);
    return new Status(cnt, (cnt == 2 ? root : null));
  }

  public static BinaryTreeNode<Integer> LowestCommonAncestor(
    BinaryTreeNode<Integer> root,
    BinaryTreeNode<Integer> na,
    BinaryTreeNode<Integer> nb)
  {
    return LCARecurse(root, na, nb).ancestor;
  }

  private static void smallTest() {
    BinaryTreeNode<Integer> root, lca, na, nb;
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 3));
    lca = root;
    na = root.left;
    nb = root.right;
//expect(LowestCommonAncestor(root, na, nb)).toBe(lca);
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    lca = root.left;
    na = root.left.left;
    nb = root.left.right;
//expect(LowestCommonAncestor(root, na, nb)).toBe(lca);
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    lca = root.right;
    na = root.right.left;
    nb = root.right.right;
//expect(LowestCommonAncestor(root, na, nb)).toBe(lca);
    root = TreeUtils.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    lca = root;
    na = root.left.right;
    nb = root.right.left;
//expect(LowestCommonAncestor(root, na, nb)).toBe(lca);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
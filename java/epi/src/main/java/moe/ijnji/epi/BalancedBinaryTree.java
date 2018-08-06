// Description:
//
// Check if a binary tree is height balanced.

package moe.ijnji.epi;

import java.lang.Math;
import moe.ijnji.rlib.BinaryTreeNode;

public class BalancedBinaryTree {

    private static int maxHeight(BinaryTreeNode<Integer> root, int height) {
        if (root == null)return height - 1;
        return Math.max(maxHeight(root.left, height + 1), maxHeight(root.right, height + 1));
    }

    private static int minHeight(BinaryTreeNode<Integer> root, int height) {
        if (root == null) return height - 1;
        return Math.min(minHeight(root.left, height + 1), minHeight(root.right, height + 1));
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        int maxh = Math.max(maxHeight(root.left, 1), maxHeight(root.right, 1));
        int minh = Math.min(minHeight(root.left, 1), minHeight(root.right, 1));
        if (Math.abs(maxh - minh) > 1) return false;
        else return true;
    }

}

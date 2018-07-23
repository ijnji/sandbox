// Description:
//
// Print the data in a binary tree using an inorder traversal using constant
// space.

package epi;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import rlib.BinaryTreeNode;
import rlib.TreeUtils;
import static rlib.TestingUtils.expect;

public class InorderConstantSpace {

  public static List<Integer> inorderConstantSpace(BinaryTreeNode<Integer> root) {
    BinaryTreeNode<Integer> curr = root;
    BinaryTreeNode<Integer> prev = null;
    List<Integer> result = new ArrayList<>();
    while (curr != null) {
      BinaryTreeNode<Integer> next;
      if (curr.parent == prev) {
        if (curr.left != null) {
          next = curr.left;
        } else {
          result.add(curr.data);
          next = (curr.right != null) ? curr.right : curr.parent;
        }
      } else if (curr.left == prev) {
        result.add(curr.data);
        next = (curr.right != null) ? curr.right : curr.parent;
      } else {
        next = curr.parent;
      }
      prev = curr;
      curr = next;
    }
    return result;
  }

  private static void smallTest() {
    BinaryTreeNode<Integer> root;
    List<Integer> result, expected;

    root = TreeUtils.buildTreeWithParent(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    result = inorderConstantSpace(root);
    expected = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
    expect(result).toBe(expected);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

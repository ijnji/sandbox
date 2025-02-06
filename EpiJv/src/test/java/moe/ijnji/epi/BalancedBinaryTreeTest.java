package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rjlib.BinaryTreeNode;
import moe.ijnji.rjlib.TreeUtils;
import org.junit.Test;
import static moe.ijnji.epi.BalancedBinaryTree.isBalanced;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BalancedBinaryTreeTest {

    @Test
    public void testSimple() {
        BinaryTreeNode<Integer> root;
        root = TreeUtils.buildTree(Arrays.asList(1));
        assertThat(isBalanced(root), is(true));
        root = TreeUtils.buildTree(Arrays.asList(1, 2, 3));
        assertThat(isBalanced(root), is(true));
        root = TreeUtils.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThat(isBalanced(root), is(true));
        root = TreeUtils.buildTree(Arrays.asList(1, 2, 3, null, null, 6, 7));
        assertThat(isBalanced(root), is(true));
        root = TreeUtils.buildTree(Arrays.asList(1, null, 3, null, null, null, 7));
        assertThat(isBalanced(root), is(false));
    }

}

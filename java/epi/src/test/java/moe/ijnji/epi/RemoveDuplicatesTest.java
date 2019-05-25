package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.LinkedListNode;
import moe.ijnji.rlib.ListUtils;
import org.junit.Test;
import static moe.ijnji.epi.RemoveDuplicates.removeDuplicates;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RemoveDuplicatesTest {

    @Test
    public void testSimple() {
        LinkedListNode<Integer> head, expected;

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 2, 2, 3, 3, 4));
        head = removeDuplicates(head);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4));
        assertThat(ListUtils.equivalence(head, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1, 1));
        head = removeDuplicates(head);
        expected = ListUtils.buildSingleList(Arrays.asList(1));
        assertThat(ListUtils.equivalence(head, expected), is(true));
    }

}

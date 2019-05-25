package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.LinkedListNode;
import moe.ijnji.rlib.ListUtils;
import org.junit.Test;
import static moe.ijnji.epi.CyclicRightShift.cyclicRightShift;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CyclicRightShiftTest {

    @Test
    public void testSimple() {
        LinkedListNode<Integer> head, expected;

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        head = cyclicRightShift(head, 2);
        expected = ListUtils.buildSingleList(Arrays.asList(4, 5, 1, 2, 3));
        assertThat(ListUtils.equivalence(head, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        head = cyclicRightShift(head, 0);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(ListUtils.equivalence(head, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        head = cyclicRightShift(head, 10);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(ListUtils.equivalence(head, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        head = cyclicRightShift(head, 9);
        expected = ListUtils.buildSingleList(Arrays.asList(2, 3, 4, 5, 1));
        assertThat(ListUtils.equivalence(head, expected), is(true));
    }

}

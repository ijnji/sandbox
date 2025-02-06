package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rjlib.LinkedListNode;
import moe.ijnji.rjlib.ListUtils;
import org.junit.Test;
import static moe.ijnji.epi.RemoveKthLast.removeKthLast;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RemoveKthLastTest {

    private static boolean check(
    LinkedListNode<Integer> head1, LinkedListNode<Integer> head2)
    {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null && head2 == null) return true;
        else return false;
    }

    @Test
    public void testSimple() {
        LinkedListNode<Integer> head, expected;

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
        head = removeKthLast(head, 1);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 3));
        assertThat(check(head, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
        head = removeKthLast(head, 0);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 2));
        assertThat(check(head, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3));
        head = removeKthLast(head, 2);
        expected = ListUtils.buildSingleList(Arrays.asList(2, 3));
        assertThat(check(head, expected), is(true));
    }

}

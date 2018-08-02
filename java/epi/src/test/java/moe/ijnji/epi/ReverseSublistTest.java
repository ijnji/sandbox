package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.LinkedListNode;
import moe.ijnji.rlib.ListUtils;
import org.junit.Test;
import static moe.ijnji.epi.ReverseSublist.reverse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReverseSublistTest {

    private static boolean check(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        while (head1 != null || head2 != null) {
            if (head1.data != head2.data) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null && head2 == null) return true;
        else return false;
    }

    @Test
    public void smallTest() {
        LinkedListNode<Integer> head, result, expected;

        head = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        result = reverse(head, 1, 8);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 9, 8, 7, 6, 5, 4, 3, 2, 10));
        assertThat(check(result, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1));
        result = reverse(head, 0, 0);
        expected = ListUtils.buildSingleList(Arrays.asList(1));
        assertThat(check(result, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1, 2));
        result = reverse(head, 0, 1);
        expected = ListUtils.buildSingleList(Arrays.asList(2, 1));
        assertThat(check(result, expected), is(true));

        head = ListUtils.buildSingleList(Arrays.asList(1, 2));
        result = reverse(head, 1, 1);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 2));
        assertThat(check(result, expected), is(true));
    }

}

package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.LinkedListNode;
import moe.ijnji.rlib.ListUtils;
import org.junit.Test;
import static moe.ijnji.epi.MergeSortedLists.mergeTwoLists;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MergeSortedListsTest {

    private static boolean check(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        while (head1 != null || head2 != null) {
            if (head1.data != head2.data)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 == null && head2 == null)
            return true;
        else
            return false;
    }

    @Test
    public void testSimple() {
        LinkedListNode<Integer> headA, headB, result, expected;

        headA = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        headB = ListUtils.buildSingleList(Arrays.asList(6, 7, 8, 9, 10));
        result = mergeTwoLists(headA, headB);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertThat(check(result, expected), is(true));

        headA = ListUtils.buildSingleList(Arrays.asList(2, 4, 6, 8, 10));
        headB = ListUtils.buildSingleList(Arrays.asList(1, 3, 5, 7, 9));
        result = mergeTwoLists(headA, headB);
        expected = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        assertThat(check(result, expected), is(true));
    }

}

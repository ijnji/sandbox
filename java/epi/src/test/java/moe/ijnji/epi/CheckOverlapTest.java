package moe.ijnji.epi;

import java.util.Arrays;
import moe.ijnji.rlib.LinkedListNode;
import moe.ijnji.rlib.ListUtils;
import org.junit.Test;
import static moe.ijnji.epi.CheckOverlap.checkOverlap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class CheckOverlapTest {

    @Test
    public void testSimple() {
        LinkedListNode<Integer> headA, headB;

        // 1--2--3--4--5
        // 1-/
        headA = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        headB = ListUtils.buildSingleList(Arrays.asList(1));
        headB.next = headA.next;
        assertThat(checkOverlap(headA, headB), is(headB.next));

        // 1--2--3--4--5
        //        2--3-/
        headA = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        headB = ListUtils.buildSingleList(Arrays.asList(2, 3));
        headB.next.next = headA.next.next.next;
        assertThat(checkOverlap(headA, headB), is(headB.next.next));

        // 1--2--3--4--5
        // 1--2--3--4--5
        headA = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        headB = ListUtils.buildSingleList(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(checkOverlap(headA, headB), is(nullValue()));
    }

}

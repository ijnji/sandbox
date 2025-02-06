package moe.ijnji.epi;

import moe.ijnji.rjlib.LinkedListNode;
import org.junit.Test;
import static moe.ijnji.epi.CheckCycle.checkCycle;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckCycleTest {

    @Test
    public void testSimple() {
        LinkedListNode<Integer> five = new LinkedListNode<>(5);
        LinkedListNode<Integer> four = new LinkedListNode<>(4, five);
        LinkedListNode<Integer> three = new LinkedListNode<>(3, four);
        LinkedListNode<Integer> two = new LinkedListNode<>(2, three);
        LinkedListNode<Integer> one = new LinkedListNode<>(1, two);
        assertThat(checkCycle(one), is(false));
        four.next = two;
        assertThat(checkCycle(one), is(true));
    }

}

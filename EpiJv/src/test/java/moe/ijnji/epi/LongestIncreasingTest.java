package moe.ijnji.epi;

import org.junit.Test;
import static moe.ijnji.epi.LongestIncreasing.longestIncreasing;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LongestIncreasingTest {

    @Test
    public void testSimple() {
        int[][] m1 = {
            {1, 1, 1, 1},
            {1, 1, 2, 1},
            {1, 4, 3, 1},
            {1, 1, 1, 1}
        };
        assertThat(longestIncreasing(m1), is(4));

        int[][] m2 = {
            {1, 9, 9, 1},
            {1, 1, 3, 2},
            {3, 4, 7, 8},
            {2, 5, 6, 9}
        };
        assertThat(longestIncreasing(m2), is(8));
    }

}

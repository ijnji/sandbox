package moe.ijnji.epi;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static moe.ijnji.epi.Permutations.permutations;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PermutationsTest {

    @Test
    public void testSimple() {
        List<Integer> lis;
        List<List<Integer>> expected;

        lis = Arrays.asList(0);
        expected = Arrays.asList(
            Arrays.asList(0)
        );
        assertThat(permutations(lis), is(expected));

        lis = Arrays.asList(1, 2, 3, 4);
        expected = Arrays.asList(
            Arrays.asList(1, 2, 3, 4),
            Arrays.asList(2, 1, 3, 4),
            Arrays.asList(2, 3, 1, 4),
            Arrays.asList(2, 3, 4, 1),
            Arrays.asList(1, 3, 2, 4),
            Arrays.asList(3, 1, 2, 4),
            Arrays.asList(3, 2, 1, 4),
            Arrays.asList(3, 2, 4, 1),
            Arrays.asList(1, 3, 4, 2),
            Arrays.asList(3, 1, 4, 2),
            Arrays.asList(3, 4, 1, 2),
            Arrays.asList(3, 4, 2, 1),
            Arrays.asList(1, 2, 4, 3),
            Arrays.asList(2, 1, 4, 3),
            Arrays.asList(2, 4, 1, 3),
            Arrays.asList(2, 4, 3, 1),
            Arrays.asList(1, 4, 2, 3),
            Arrays.asList(4, 1, 2, 3),
            Arrays.asList(4, 2, 1, 3),
            Arrays.asList(4, 2, 3, 1),
            Arrays.asList(1, 4, 3, 2),
            Arrays.asList(4, 1, 3, 2),
            Arrays.asList(4, 3, 1, 2),
            Arrays.asList(4, 3, 2, 1)
        );
        assertThat(permutations(lis), is(expected));
    }

}

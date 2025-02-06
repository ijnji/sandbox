package moe.ijnji.epi;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JumpGameTest {

    @Test
    public void smallTest() {
        List<Integer> input;

        input = Arrays.asList(2, 3, 1, 1, 4);
        assertThat(JumpGame.canReachEnd(input), is(true));

        input = Arrays.asList(3, 2, 1, 0, 4);
        assertThat(JumpGame.canReachEnd(input), is(false));

        input = Arrays.asList(3, 2, 1, -10, 4);
        assertThat(JumpGame.canReachEnd(input), is(false));

        input = Arrays.asList(2, 3, -1, -1, 4);
        assertThat(JumpGame.canReachEnd(input), is(true));

        input = Arrays.asList(2, 2, -1, -1, 100);
        assertThat(JumpGame.canReachEnd(input), is(false));
    }

}

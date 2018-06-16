package moe.ijnji.epi;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JumpGameTest {

    @Test
    public void smallTest() {
        List<Integer> input;

        input = Arrays.asList(2, 3, 1, 1, 4);
        assertTrue(JumpGame.canReachEnd(input));

        input = Arrays.asList(3, 2, 1, 0, 4);
        assertFalse(JumpGame.canReachEnd(input));

        input = Arrays.asList(3, 2, 1, -10, 4);
        assertFalse(JumpGame.canReachEnd(input));

        input = Arrays.asList(2, 3, -1, -1, 4);
        assertTrue(JumpGame.canReachEnd(input));

        input = Arrays.asList(2, 2, -1, -1, 100);
        assertFalse(JumpGame.canReachEnd(input));
    }

}

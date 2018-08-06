package moe.ijnji.epi;

import org.junit.Test;
import static moe.ijnji.epi.SwapBits.swapBits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SwapBitsTest {

    @Test
    public void testSimple() {
        assertThat(swapBits((long)0b10, 1, 0), is((long)0b1));
        assertThat(swapBits((long)0b1000, 3, 0), is((long)0b1));
        assertThat(swapBits((long)0b1, 3, 0), is((long)0b1000));
    }

}

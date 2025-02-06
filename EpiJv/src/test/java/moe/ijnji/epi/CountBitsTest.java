package moe.ijnji.epi;

import org.junit.Test;
import static moe.ijnji.epi.CountBits.countBits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CountBitsTest {

    @Test
    public void smallTest() {
        assertThat(countBits(0), is((short)0));
        assertThat(countBits(1), is((short)1));
        assertThat(countBits(5), is((short)2));
        assertThat(countBits(255), is((short)8));
    }

}

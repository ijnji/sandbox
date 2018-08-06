package moe.ijnji.epi;

import org.junit.Test;
import static moe.ijnji.epi.Parity.parity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParityTest {

    @Test
    public void testSimple() {
        assertThat(parity((long)0), is((short)0));
        assertThat(parity((long)1), is((short)1));
        assertThat(parity((long)15), is((short)0));
    }

}

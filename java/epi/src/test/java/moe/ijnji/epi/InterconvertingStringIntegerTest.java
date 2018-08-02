package moe.ijnji.epi;

import org.junit.Test;
import static moe.ijnji.epi.InterconvertingStringInteger.intToString;
import static moe.ijnji.epi.InterconvertingStringInteger.stringToInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InterconvertingStringIntegerTest {

    @Test
    public void testSimple() {
        assertThat(intToString(0), is("0"));
        assertThat(intToString(-1), is("-1"));
        assertThat(intToString(1), is("1"));
        assertThat(intToString(2), is("2"));
        assertThat(intToString(-2), is("-2"));
        assertThat(intToString(9), is("9"));
        assertThat(intToString(10), is("10"));
        assertThat(intToString(123), is("123"));
        assertThat(intToString(Integer.MAX_VALUE), is(Integer.toString(Integer.MAX_VALUE)));

        assertThat(stringToInt(""), is(0));
        assertThat(stringToInt("0"), is(0));
        assertThat(stringToInt("-1"), is(-1));
        assertThat(stringToInt("1"), is(1));
        assertThat(stringToInt("2"), is(2));
        assertThat(stringToInt("-2"), is(-2));
        assertThat(stringToInt("9"), is(9));
        assertThat(stringToInt("10"), is(10));
        assertThat(stringToInt("123"), is(123));
        assertThat(stringToInt(Integer.toString(Integer.MAX_VALUE)), is(Integer.MAX_VALUE));
    }

}

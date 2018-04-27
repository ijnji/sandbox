package moe.ijnji.epi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterconvertingStringIntegerTest {

    @Test
    public void testSimple() {
        assertEquals(InterconvertingStringInteger.intToString(0), "0");
        assertEquals(InterconvertingStringInteger.intToString(-1), "-1");
        assertEquals(InterconvertingStringInteger.intToString(1), "1");
        assertEquals(InterconvertingStringInteger.intToString(2), "2");
        assertEquals(InterconvertingStringInteger.intToString(-2), "-2");
        assertEquals(InterconvertingStringInteger.intToString(9), "9");
        assertEquals(InterconvertingStringInteger.intToString(10), "10");
        assertEquals(InterconvertingStringInteger.intToString(123), "123");
        assertEquals(InterconvertingStringInteger.intToString(Integer.MAX_VALUE), Integer.toString(Integer.MAX_VALUE));

        assertEquals(InterconvertingStringInteger.stringToInt(""), 0);
        assertEquals(InterconvertingStringInteger.stringToInt("0"), 0);
        assertEquals(InterconvertingStringInteger.stringToInt("-1"), -1);
        assertEquals(InterconvertingStringInteger.stringToInt("1"), 1);
        assertEquals(InterconvertingStringInteger.stringToInt("2"), 2);
        assertEquals(InterconvertingStringInteger.stringToInt("-2"), -2);
        assertEquals(InterconvertingStringInteger.stringToInt("9"), 9);
        assertEquals(InterconvertingStringInteger.stringToInt("10"), 10);
        assertEquals(InterconvertingStringInteger.stringToInt("123"), 123);
        assertEquals(InterconvertingStringInteger.stringToInt(Integer.toString(Integer.MAX_VALUE)), Integer.MAX_VALUE);
    }

}

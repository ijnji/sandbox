// Description:
//
// Swap the zero-based i-th and j-th bits in a given number.

package moe.ijnji.epi;

public class SwapBits {

    public static long swapBits(long x, int i, int j) {
        long l = x & (1L << i);
        long r = x & (1L << j);
        if ((l == 0 && r == 0) || (l != 0 && r != 0))
            return x;
        x = x ^ (1L << i);
        x = x ^ (1L << j);
        return x;
    }

}
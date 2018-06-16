// Description:
//
// Find the parity of the bits of a number where 0 is even and 1 is odd.

package moe.ijnji.epi;

public class Parity {

    public static short parity(long x) {
        short result = 0;
        while (x > 0) {
            x = (x - 1) & x;
            result ^= 1;
        }
        return result;
    }

}
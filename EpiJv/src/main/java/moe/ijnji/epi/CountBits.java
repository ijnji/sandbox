// Description:
//
// Count the number of bits in an integer.

package moe.ijnji.epi;

public class CountBits {

    public static short countBits(int x) {
        short total = 0;
        while (x > 0) {
            x = (x - 1) & x;
            total++;
        }
        return total;
    }

}
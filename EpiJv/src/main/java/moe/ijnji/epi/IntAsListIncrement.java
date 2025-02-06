// Description:
//
// Given an integer as a list, increment it.

package moe.ijnji.epi;

import java.util.Collections;
import java.util.List;

public class IntAsListIncrement {

    public static List<Integer> plusOne(List<Integer> A) {
        Collections.reverse(A);
        int carry = 1;
        for (int i = 0; i < A.size(); i++) {
            int res = A.get(i) + carry;
            int d = res % 10;
            carry = res / 10;
            A.set(i, d);
        }
        if (carry > 0)
            A.add(carry);
        Collections.reverse(A);
        return A;
    }

}
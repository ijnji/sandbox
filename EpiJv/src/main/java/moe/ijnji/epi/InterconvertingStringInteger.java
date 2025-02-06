// Description:
//
// Convert string to int and int to string.

package moe.ijnji.epi;

import java.lang.StringBuilder;

public class InterconvertingStringInteger {

    public static String intToString(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = -x;
        }
        StringBuilder sb = new StringBuilder();
        if (x == 0) {
            sb.append('0');
        } else {
            while (x > 0) {
                sb.append((char)('0' + x % 10));
                x /= 10;
            }
        }
        if (isNeg) sb.append('-');
        return sb.reverse().toString();
    }

    public static int stringToInt(String s) {
        if (s.isEmpty())
            return 0;
        boolean isNeg = (s.charAt(0) == '-') ? true : false;
        int res = 0;
        for (int i = (isNeg) ? 1 : 0; i < s.length(); i++) {
            res = (res * 10) + s.charAt(i) - '0';
        }
        return (isNeg) ? -res : res;
    }

}
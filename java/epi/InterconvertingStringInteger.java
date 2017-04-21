// Description:
//
// Convert string to int and int to string.

package epi;

import java.lang.StringBuilder;
import static rlib.TestingUtils.expect;

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

  private static int stringToInt(String s) {
    boolean isNeg = (s.charAt(0) == '-') ? true : false;
    int res = 0;
    for (int i = (isNeg) ? 1 : 0; i < s.length(); i++) {
      res = (res * 10) + s.charAt(i) - '0';
    }
    return (isNeg) ? -res : res;
  }

  private static void smallTest() {
    expect(intToString(0)).toBe("0");
    expect(intToString(-1)).toBe("-1");
    expect(intToString(1)).toBe("1");
    expect(intToString(2)).toBe("2");
    expect(intToString(-2)).toBe("-2");
    expect(intToString(9)).toBe("9");
    expect(intToString(10)).toBe("10");
    expect(intToString(123)).toBe("123");
    expect(intToString(Integer.MAX_VALUE)).toBe(Integer.toString(Integer.MAX_VALUE));

    expect(stringToInt("0")).toBe(0);
    expect(stringToInt("-1")).toBe(-1);
    expect(stringToInt("1")).toBe(1);
    expect(stringToInt("2")).toBe(2);
    expect(stringToInt("-2")).toBe(-2);
    expect(stringToInt("9")).toBe(9);
    expect(stringToInt("10")).toBe(10);
    expect(stringToInt("123")).toBe(123);
    expect(stringToInt(Integer.toString(Integer.MAX_VALUE))).toBe(Integer.MAX_VALUE);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
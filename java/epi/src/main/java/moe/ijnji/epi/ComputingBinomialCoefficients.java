// Description:
//
// Find an efficient way of computing n Cr k, "N choose K", since the
// numerator or denominator of the equivalent expression, n! / (k!(n - k)!),
// may overflow a 32-bit int even if the result does not.

package epi;

import static rlib.TestingUtils.expect;

public class ComputingBinomialCoefficients {

  public static int computeBinomialCoefficients(int n, int k) {
    return 0;
  }

  private static void smallTest() {
    expect(computeBinomialCoefficients(3, 1)).toBe(3);
    expect(computeBinomialCoefficients(3, 3)).toBe(1);
    expect(computeBinomialCoefficients(5, 2)).toBe(10);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
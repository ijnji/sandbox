// Description:
//
// Given an array of integers A, where A[i] denotes max possible moves starting from i.
// Return if it's possible to move to last index of A starting from i = 0.

package epi;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpGame {

  private static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
    int end = maxAdvanceSteps.size() - 1;
    int far = 0;
    for (int i = 0; i < maxAdvanceSteps.size(); i++) {
      if (i > far) return false;
      far = Math.max(far, i + maxAdvanceSteps.get(i));
      if (far >= end) return true;
    }
    return false;
  }

  private static void smallTest() {
    assert(canReachEnd(Arrays.asList(2, 3, 1, 1, 4)));
    assert(!canReachEnd(Arrays.asList(3, 2, 1, 0, 4)));
    assert(!canReachEnd(Arrays.asList(3, 2, 1, -10, 4)));
    assert(canReachEnd(Arrays.asList(2, 3, -1, -1, 4)));
    assert(!canReachEnd(Arrays.asList(2, 2, -1, -1, 100)));
  }

  public static void main(String[] args) {
    smallTest();
  }

}
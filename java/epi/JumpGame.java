// Description:
//   Given an array of integers A, where A[i] denotes max possible moves starting from i.
//   Return if it's possible to move to last index of A starting from i = 0.
package epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class JumpGame {

  private static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
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
    Random r = new Random();
    final int N = r.nextInt(1000) + 1;
    List<Integer> maxAdvanceSteps = new ArrayList<>(N);
    IntStream.range(0, N).forEach(n -> {
      maxAdvanceSteps.add(r.nextInt(10) + 1);
    });
    System.out.println(canReachEnd(maxAdvanceSteps));
  }

}
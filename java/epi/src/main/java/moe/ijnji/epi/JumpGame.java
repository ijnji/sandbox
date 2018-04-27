// Description:
//
// Given an array of integers A, where A[i] denotes max possible moves
// starting from i, return whether or not it's possible to move from
// i = 0 to the last index, i = |A| - 1.

package moe.ijnji.epi;

import java.lang.Math;
import java.util.List;

public class JumpGame {

    public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int end = maxAdvanceSteps.size() - 1;
        int far = 0;
        for (int i = 0; i < maxAdvanceSteps.size(); i++) {
            if (i > far) return false;
            far = Math.max(far, i + maxAdvanceSteps.get(i));
            if (far >= end) return true;
        }
        return false;
    }

}
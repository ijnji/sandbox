// Description:
//
// Find all distinct placements of n queens on an nxn board in nonattacking positions.

package moe.ijnji.epi;

import java.util.List;

public class NonattackingQueen {

   public static void solve(List<List<Integer>> pegs) {
       move(pegs, pegs.get(0).size(), 0, 2, 1);
   }

   private static void move(List<List<Integer>> pegs, int amount, int source, int target, int thru) {
       if (amount == 0) return;
       move(pegs, amount - 1, source, thru, target);
       int p = pegs.get(source).remove(pegs.get(source).size() - 1);
       pegs.get(target).add(p);
       move(pegs, amount - 1, thru, target, source);
   }

}

// Description:
//
// Write a function to solve to the Tower of Hanoi problem. Solved is defined as
// moving all plates from peg 0 to peg 2. Every plate is equal to or smaller than
// the plate immediately below itself. Only one plate is moved at a time.

package moe.ijnji.epi;

import java.util.List;

public class TowerOfHanoi {

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

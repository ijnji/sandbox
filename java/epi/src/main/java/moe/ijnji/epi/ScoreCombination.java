// Description:
//
// Given a list of plays, their individual worth in score points, and
// a total score, return the number of all combinations of plays that
// sum up to the given total score.

package moe.ijnji.epi;

import java.lang.Math;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class ScoreCombination {

  public static int combinations(int totalScore, List<Integer> playScores) {
    List<List<Integer>> memo = new ArrayList<>();
    for (int i = 0; i < playScores.size(); i++) {
      List<Integer> row = new ArrayList<Integer>();
      for (int j = 0; j <= totalScore; j++) {
        int c = 0;
        if (i == 0) {
          c = (j % playScores.get(0) == 0) ? 1 : 0;
        } else {
          List<Integer> prow = memo.get(i - 1);
          for (int k = j; k >= 0; k -= playScores.get(i)) {
            c += prow.get(k);
          }
        }
        row.add(c);
      }
      memo.add(row);
    }
    return memo.get(playScores.size() - 1).get(totalScore);
  }

  private static void smallTest() {
    List<Integer> playScores;
    playScores = Arrays.asList(2);
    //expect(combinations(1, playScores)).toBe(0);
    //expect(combinations(2, playScores)).toBe(1);
    playScores = Arrays.asList(2, 3, 7);
    //expect(combinations(5, playScores)).toBe(1);
    //expect(combinations(9, playScores)).toBe(3);
    //expect(combinations(12, playScores)).toBe(4);
    playScores = Arrays.asList(1, 5, 10, 25);
    //expect(combinations(5, playScores)).toBe(2);
    //expect(combinations(10, playScores)).toBe(4);
    //expect(combinations(50, playScores)).toBe(49);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
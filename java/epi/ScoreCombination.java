// Description:
//
// Given a list of plays, their individual worth in score points, and
// a total score, return the number of all combinations of plays that
// sum up to the given total score.

package epi;

import java.lang.Math;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static rlib.Testing.expect;

public class ScoreCombination {

  public static int combinations(int totalScore, List<Integer> playScores) {
    return 0;
  }

  public static void smallTest() {
    List<Integer> playScores;
    playScores = Arrays.asList(2);
    expect(combinations(2, playScores)).toBe(1);
    expect(combinations(1, playScores)).toBe(0);
    playScores = Arrays.asList(2, 3, 7);
    expect(combinations(12, playScores)).toBe(4);
    expect(combinations(9, playScores)).toBe(3);
    expect(combinations(5, playScores)).toBe(1);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
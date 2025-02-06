// Description:
//
// Find the Levenshtein distance between two given words. The Levenshtein 
// distance is defined as the minimum number of edits needed to morph one word
// to another word, where the edit operations comprise of 1) replacing a letter,
// 2) inserting a letter, and 3) deleting a letter.

package moe.ijnji.epi;

import java.lang.Math;
import java.util.Arrays;
import java.util.List;


public class LevenshteinDistance {

  private static int levenshteinRecurse(String s1, String s2) {
    if (s1.equals("")) return s2.length();
    if (s2.equals("")) return s1.length();
    if (s1.charAt(0) == s2.charAt(0)) {
      return levenshteinDistance(s1.substring(1), s2.substring(1));
    } else {
      int deleteOp = levenshteinDistance(s1.substring(1), s2);
      int insertOp = levenshteinRecurse(s1, s2.substring(1));
      int replaceOp = levenshteinRecurse(s1.substring(1), s2.substring(1));
      return 1 + Math.min(deleteOp, Math.min(insertOp, replaceOp));
    }
  }

  public static int levenshteinDistance(String s1, String s2) {
    return levenshteinRecurse(s1, s2);
  }

  private static void smallTest() {
    List<String>  words;
    words = Arrays.asList("", "");
    //expect(levenshteinDistance(words.get(0), words.get(1))).toBe(0);
    words = Arrays.asList("a", "a");
    //expect(levenshteinDistance(words.get(0), words.get(1))).toBe(0);
    words = Arrays.asList("z", "x");
    //expect(levenshteinDistance(words.get(0), words.get(1))).toBe(1);
    words = Arrays.asList("Friday", "Friday");
    //expect(levenshteinDistance(words.get(0), words.get(1))).toBe(0);
    words = Arrays.asList("Saturday", "Sundays");
    //expect(levenshteinDistance(words.get(0), words.get(1))).toBe(4);
    words = Arrays.asList("Carthorse", "Orchestra");
    //expect(levenshteinDistance(words.get(0), words.get(1))).toBe(8);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
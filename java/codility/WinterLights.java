package codility;

import java.util.HashMap;
import java.util.Map;

class Solution {

  public int solution(String S) {
    int res = 0;
    for (int i = 0; i < S.length(); i++) {
      for (int ln = 1; i + ln <= S.length(); ln++) {
        if (canReverse(S.substring(i, i + ln))) res++;
      }
    }
    return res;
  }

  private boolean canReverse(String S) {
    Map<Character, Integer> hm = new HashMap<>();
    for (char c : S.toCharArray()) {
      if (hm.get(c) == null) hm.put(c, 1);
      else hm.put(c, hm.get(c) + 1);
    }
    boolean hasOdd = false;
    for (char c : hm.keySet()) {
      if (hm.get(c) % 2 == 1) {
        if (!hasOdd) hasOdd = true;
        else return false;
      }
    }
    return true;
  }
  
}
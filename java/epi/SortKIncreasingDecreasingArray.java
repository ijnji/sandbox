// Description:
//
// Given a list with K increasing-decreasing integers, write a function to
// efficiently sort the list.

package epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static epi.MergeSortedArrays.mergeSortedLists;
import static rlib.TestingUtils.expect;

public class SortKIncreasingDecreasingArray {

  public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> list) {
    if (list == null || list.size() == 0) return list;
    boolean isInc = true;
    List<List<Integer>> subl = new ArrayList<>();
    int i = 0;
    int j = 1;
    int n = list.get(0);
    while (j < list.size()) {
      int m = list.get(j);
      if (isInc && m < n || !isInc && n < m) {
        List<Integer> l = list.subList(i, j);
        if (!isInc) Collections.reverse(l);
        subl.add(l);
        isInc = !isInc;
        i = j;
      }
      n = m;
      j++;
    }
    subl.add(list.subList(i, j));
    Collections.reverse(subl.get(subl.size() - 1));
    return mergeSortedLists(subl);
  }

  private static void smallTest() {
    List<Integer> list;
    list = Arrays.asList();
    expect(sortKIncreasingDecreasingArray(list)).toBe(Arrays.asList());
    list = Arrays.asList(
      57, 131, 493, 294, 221, 339, 418, 452, 442, 190
    );
    expect(sortKIncreasingDecreasingArray(list)).toBe(Arrays.asList(
      57, 131, 190, 221, 294, 339, 418, 442, 452, 493
    ));
  }

  public static void main(String[] args) {
    smallTest();
  }

}
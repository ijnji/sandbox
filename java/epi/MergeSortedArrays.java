// Description:
//
// Given a set of sorted lists of integers and assuming none of the lists can
// fit in memory at once, but one member from all lists can be, merge all lists
// together into one sorted list.

package epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import static rlib.TestingUtils.expect;

public class MergeSortedArrays {

  private static class Tuple {
    public int value;
    public int id;
    public Tuple(int value, int id) {
      this.value = value;
      this.id = id;
    }
  }

  public static List<Integer> mergeSortedLists(List<List<Integer>> lists) {

  }

  private static void smallTest() {
    List<List<Integer>> lists;
    lists = new ArrayList<>();
    lists.add(Arrays.asList(3, 5, 7));
    lists.add(Arrays.asList(0, 6));
    lists.add(Arrays.asList(0, 6, 28));
    expect(mergeSortedLists(lists)).toBe(Arrays.asList(
      0, 0, 3, 5, 6, 6, 7, 28
    ));
  }

  public static void main(String[] args) {
    smallTest();
  }

}
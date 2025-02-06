// Description:
//
// Given a set of sorted lists of integers and assuming none of the lists can
// fit in memory at once, but an iterator to each list is available in memory,
// merge all lists together into one sorted list.

package moe.ijnji.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


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
    List<Iterator<Integer>> itl = new ArrayList<>();
    for (List<Integer> l : lists) {
      itl.add(l.iterator());
    }
    Queue<Tuple> pque = new PriorityQueue<>(
      lists.size(),
      new Comparator<Tuple>() {
        public int compare(Tuple a, Tuple b) {
          return Integer.compare(a.value, b.value);
        }
      }
    );
    for (int i = 0; i < itl.size(); i++) {
      Iterator<Integer> it = itl.get(i);
      if (it.hasNext()) {
        pque.add(new Tuple(it.next(), i));
      }
    }
    List<Integer> res = new ArrayList<>();
    while (pque.size() > 0) {
      Tuple t = pque.poll();
      res.add(t.value);
      Iterator<Integer> it = itl.get(t.id);
      if (it.hasNext()) {
        pque.add(new Tuple(it.next(), t.id));
      }
    }
    return res;
  }

  private static void smallTest() {
    List<List<Integer>> lists;
    lists = new ArrayList<>();
    lists.add(Arrays.asList());
    //expect(mergeSortedLists(lists)).toBe(Arrays.asList());
    lists = new ArrayList<>();
    lists.add(Arrays.asList(0));
    lists.add(Arrays.asList(1));
    lists.add(Arrays.asList(2));
    lists.add(Arrays.asList(3));
    lists.add(Arrays.asList(4));
    lists.add(Arrays.asList(5));
    //expect(mergeSortedLists(lists)).toBe(Arrays.asList(
//      0, 1, 2, 3, 4, 5
//    ));
    lists = new ArrayList<>();
    lists.add(Arrays.asList(3, 5, 7));
    lists.add(Arrays.asList(0, 6));
    lists.add(Arrays.asList(0, 6, 28));
    //expect(mergeSortedLists(lists)).toBe(Arrays.asList(
//      0, 0, 3, 5, 6, 6, 7, 28
//    ));
  }

  public static void main(String[] args) {
    smallTest();
  }

}
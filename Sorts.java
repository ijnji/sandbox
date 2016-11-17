import java.io.*;
import java.util.*;

public class Sorts {
    private static List<Integer> randArray(int len) {
        Random rand = new Random();
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            out.add(rand.nextInt(100));
        }
        return out;
    }

    private static List<Integer> copy(List<Integer> in) {
        List<Integer> out = new ArrayList<>();
        for (int x : in) {
            out.add(x);
        }
        return out;
    }

    private static boolean compare(List<Integer> in1, List<Integer> in2) {
        if (in1.size() != in2.size()) return false;
        for (int i = 0; i < in1.size(); i++) {
            if (in1.get(i) != in2.get(i)) return false;
        }
        return true;
    }

    private static void check(List<Integer> expected, List<Integer> received) {
        System.out.println("-------------------------");
        if (!compare(expected, received)) {
            System.out.println("Check failed.");
            System.out.println("expected: " + expected);
            System.out.println("received: " + received);
        } else {
            System.out.println("Check passed.");
        }
    }

    private static List<Integer> sortInsertion(List<Integer> in) {
        if (in.isEmpty()) return in;
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < in.size(); i++) {
            for (int j = 0; j < out.size(); j++) {
                if (!out.isEmpty() && out.get(j) >= in.get(i)) {
                    out.add(j, in.get(i));
                    break;
                }
                out.add(in.get(i));
            }
        }
        return out;
    }

    private static List<Integer> sortSelection(List<Integer> in) {
        for (int i = 0; i < in.size(); i++) {
            int min = in.get(i);
            int minj = i;
            for (int j = i; j < in.size(); j++) {
                if (in.get(j) < min) {
                    min = in.get(j);
                    minj = j;
                }
            }
            Collections.swap(in, i, minj);
        }
        return in;
    }

    private static List<Integer> sortBubble(List<Integer> in) {
        if (in.isEmpty()) return in;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < in.size() - 1; i++) {
                if (in.get(i) > in.get(i + 1)) {
                    Collections.swap(in, i, i + 1);
                    swapped = true;
                }
            }
        }
        return in;
    }

    private static List<Integer> sortMerge(List<Integer> in) {
        return combine(
            in.subList(0, in.size() / 2),
            in.subList(in.size() / 2, in.size())
        );
    }

    private static List<Integer> combine(List<Integer> l, List<Integer> r) {
        if (l.size() > 1) l = combine(
            l.subList(0, l.size() / 2),
            l.subList(l.size() / 2, l.size())
        );
        if (r.size() > 1) r = combine(
            r.subList(0, r.size() / 2),
            r.subList(r.size() / 2, r.size())
        );
        List<Integer> out = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l.size() && j < r.size()) {
            if (l.get(i) < r.get(j)) {
                out.add(l.get(i));
                i++;
            } else {
                out.add(r.get(j));
                j++;
            }
        }
        while (i < l.size()) {
            out.add(l.get(i));
            i++;
        }
        while (j < r.size()) {
            out.add(r.get(j));
            j++;
        }
        return out;
    }

    private static List<Integer> sortHeap(List<Integer> in) {
        List<Integer> out = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<Integer>();
        for (int e : in) {
            q.add(e);
        }
        while (q.iterator().hasNext()) {
            out.add(q.iterator().next());
            q.remove();
        }
        return out;
    }

    private static List<Integer> sortQuick(List<Integer> in) {
        partition(in, 0, in.size());
        return in;
    }

    private static void partition(List<Integer> in, int l, int r) {
        if (r - l < 2) return;
        int piv = in.get(r - 1);
        int lo = l;
        for (int i = l; i < r - 1; i++) {
            if (in.get(i) < piv) {
                Collections.swap(in, i, lo++);
            }
        }
        Collections.swap(in, r - 1, lo);
        int hi = r;
        for (int i = r - 1; i > lo; i--) {
            if (in.get(i) > piv) {
                Collections.swap(in, i, --hi);
            }
        }
        partition(in, l, lo);
        partition(in, hi, r);
    }

    public static void main(String[] args) {
        List<Integer> original = randArray(100);
        List<Integer> sorted = copy(original);
        Collections.sort(sorted);

        System.out.println();
        System.out.println("Insertion Sort");
        check(sorted, sortBubble(copy(original)));

        System.out.println();
        System.out.println("Selection Sort");
        check(sorted, sortSelection(copy(original)));

        System.out.println();
        System.out.println("Bubble Sort");
        check(sorted, sortBubble(copy(original)));

        System.out.println();
        System.out.println("Merge Sort");
        check(sorted, sortMerge(copy(original)));

        System.out.println();
        System.out.println("Heap Sort");
        check(sorted, sortHeap(copy(original)));

        System.out.println();
        System.out.println("Quick Sort");
        check(sorted, sortQuick(copy(original)));
    }
}
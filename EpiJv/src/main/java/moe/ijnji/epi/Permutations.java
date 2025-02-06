// Description:
//
// Given a list of integers, return all permutations of the list.

package moe.ijnji.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> lis) {
        List<List<Integer>> res = new ArrayList<>();
        if (lis.size() == 0)
            return res;

        int a = lis.get(0);
        List<List<Integer>> inners = permutations(lis.subList(1, lis.size()));
        if (inners.size() == 0) {
            res.add(Arrays.asList(a));
            return res;
        }

        for (List<Integer> inner : inners)
            res.addAll(interleave(inner, a));

        return res;
    }

    private static List<List<Integer>> interleave(List<Integer> lis, int a) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= lis.size(); i++) {
            List<Integer> left = lis.subList(0, i);
            List<Integer> right = lis.subList(i, lis.size());
            List<Integer> curr = new ArrayList<>();
            curr.addAll(left);
            curr.add(a);
            curr.addAll(right);
            res.add(curr);
        }

        return res;
    }

}
// Description:
//
// Given a list of integers, generate its powerset.  A powerset is a set
// that contains all possible subsets including the empty set.

package moe.ijnji.epi;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> pset = new ArrayList<>();
        if (inputSet.size() > 0) {
            pset = generatePowerSet(inputSet.subList(1, inputSet.size()));
        } else {
            pset.add(new ArrayList<>());
            return pset;
        }
        int c = inputSet.get(0);
        List<List<Integer>> cset = new ArrayList<>();
        for (List<Integer> l : pset) {
            List<Integer> without = new ArrayList<>(l);
            cset.add(without);
            List<Integer> with = new ArrayList<>(l);
            with.add(c);
            cset.add(with);
        }
        return cset;
    }

}
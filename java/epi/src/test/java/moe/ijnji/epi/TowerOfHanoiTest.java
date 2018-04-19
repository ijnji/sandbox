package moe.ijnji.epi;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TowerOfHanoiTest {

    private static boolean check(List<List<Integer>> pegs) {
        if (pegs.get(0).size() != 0) return false;
        if (pegs.get(1).size() != 0) return false;
        int prev = pegs.get(2).get(0);
        for (int p : pegs.get(2)) {
            if (prev > p) return false;
            prev = p;
        }
        return true;
    }

    private static List<List<Integer>> construct(int n) {
        List<List<Integer>> pegs = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        while (n-- > 0)
            stack.add(n);
        pegs.add(stack);
        pegs.add(new ArrayList<>());
        pegs.add(new ArrayList<>());
        return pegs;
    }

    @Test
    public void testSimple() {
        List<List<Integer>> pegs;

        pegs = construct(1);
        TowerOfHanoi.solve(pegs);
        assertTrue(check(pegs));
    }
}

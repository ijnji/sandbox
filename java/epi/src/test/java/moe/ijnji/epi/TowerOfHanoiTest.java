package moe.ijnji.epi;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TowerOfHanoiTest {

    private static boolean check(List<List<Integer>> pegs) {
        if (pegs.get(0).size() != 0) return false;
        if (pegs.get(1).size() != 0) return false;
        List<Integer> stack = pegs.get(2);
        int prev = stack.get(0);
        for (int p : stack) {
            if (p > prev)
                return false;
            prev = p;
        }
        return true;
    }

    private static List<List<Integer>> construct(int n) {
        List<List<Integer>> pegs = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        while (n > 0) {
            stack.add(n);
            n--;
        }
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

        pegs = construct(2);
        TowerOfHanoi.solve(pegs);
        assertTrue(check(pegs));

        pegs = construct(3);
        TowerOfHanoi.solve(pegs);
        assertTrue(check(pegs));

        pegs = construct(15);
        TowerOfHanoi.solve(pegs);
        assertTrue(check(pegs));
    }
}

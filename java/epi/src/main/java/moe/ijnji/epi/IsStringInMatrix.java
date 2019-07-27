// Description:
//
// Given a 2D array of integers and a list of integers, write a function
// that tells whether or not the list of integers can be found in the array.

package moe.ijnji.epi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class IsStringInMatrix {

    public static boolean isPatternContainedInGrid(List<List<Integer>> grid, List<Integer> pattern) {
        Map<Entry, Boolean> cache = new HashMap<>();
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.get(r).size(); c++) {
                recurse(cache, grid, pattern, r, c, 0);
                boolean result = cache.get(new Entry(r, c, 0));
                if (result)
                    return true;
            }
        }
        return false;
    }

    private static boolean recurse(
        Map<Entry, Boolean> cache,
        List<List<Integer>> grid,
        List<Integer> pattern,
        int row,
        int col,
        int index)
    {
        if (cache.containsKey(new Entry(row, col, index)))
            return cache.get(new Entry(row, col, index));
        if (index == pattern.size())
            return true;
        if (row < 0 || row >= grid.size() || col < 0 || col >= grid.get(0).size())
            return false;
        if (grid.get(row).get(col) != pattern.get(index)) {
            cache.put(new Entry(row, col, index), false);
            return false;
        }

        boolean top = recurse(cache, grid, pattern, row - 1, col, index + 1);
        boolean bottom = recurse(cache, grid, pattern, row + 1, col, index + 1);
        boolean left = recurse(cache, grid, pattern, row, col - 1, index + 1);
        boolean right = recurse(cache, grid, pattern, row, col + 1, index + 1);

        boolean result = (top || bottom || left || right);
        cache.put(new Entry(row, col, index), result);
        return result;
    }

    private static class Entry {
        public int row;
        public int col;
        public int index;
        public Entry(int row, int col, int index) {
            this.row = row;
            this.col = col;
            this.index = index;
        }
        @Override
        public int hashCode() {
            return Objects.hash(row, col, index);
        }
        @Override
        public boolean equals(Object other) {
            Entry o = (Entry)other;
            if (this.row != o.row)
                return false;
            if (this.col != o.col)
                return false;
            if (this.index != o.index)
                return false;
            return true;
        }
    }

}
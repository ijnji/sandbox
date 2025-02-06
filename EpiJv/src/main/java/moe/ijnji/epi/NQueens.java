// Description:
//
// Find all non-attacking queen placements for an n queens on an nxn board.

package moe.ijnji.epi;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        recurse(res, new ArrayList<Integer>(n), n);
        return res;
    }

    private static void recurse(List<List<Integer>> res, List<Integer> brd, int n) {
        for (int pos = 0; pos < n; pos++) {
            if (placeable(brd, n, pos)) {
                List<Integer> cpy = new ArrayList<>(brd);
                cpy.add(pos);
                if (cpy.size() == n) {
                    res.add(cpy);
                } else {
                    recurse(res, cpy, n);
                }
            }
        }
    }

    private static boolean placeable(List<Integer> brd, int n, int pos) {
        for (int off = 0; off < brd.size(); off++) {
            int row = brd.size() - 1 - off;
            int left = pos - off - 1;
            int right = pos + off + 1;
            if (brd.get(row) == pos)
                return false;
            if (left >= 0 && brd.get(row) == left)
                return false;
            if (right < n && brd.get(row) == right)
                return false;
        }
        return true;
    }

}
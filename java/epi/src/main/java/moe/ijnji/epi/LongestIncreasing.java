// Description:
//
// Given a 2D array of positive integers, find the length of the longest
// decreasing list formed from cardinally adjacent spaces.

package moe.ijnji.epi;

public class LongestIncreasing {

    public static int longestIncreasing(int[][] m) {
        int[][] cache = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                cache[i][j] = 1;
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                helper(m, cache, i, j);
            }
        }
        int result = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                result = Math.max(result, cache[i][j]);
            }
        }
        return result;
    }

    private static void helper(int[][] m, int[][] cache, int i, int j) {
        int up = 0, down = 0, left = 0, right = 0;
        if (i - 1 >= 0 && m[i - 1][j] < m[i][j]) {
            if (cache[i - 1][j] == 1) {
                helper(m, cache, i - 1, j);
            }
            up = cache[i - 1][j] + 1;
        }
        if (i + 1 < m.length && m[i + 1][j] < m[i][j]) {
            if (cache[i + 1][j] == 1) {
                helper(m, cache, i + 1, j);
            }
            down = cache[i + 1][j] + 1;
        }
        if (j - 1 >= 0 && m[i][j - 1] < m[i][j]) {
            if (cache[i][j - 1] == 1) {
                helper(m, cache, i, j - 1);
            }
            left = cache[i][j - 1] + 1;
        }
        if (j + 1 < m.length && m[i][j + 1] < m[i][j]) {
            if (cache[i][j + 1] == 1) {
                helper(m, cache, i, j + 1);
            }
            right = cache[i][j + 1] + 1;
        }
        int here = Math.max(up, down);
        here = Math.max(here, left);
        here = Math.max(here, right);
        cache[i][j] = Math.max(cache[i][j], here);
    }

}
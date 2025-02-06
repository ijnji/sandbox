// Description:
//
// Given an R-C 2D grid, count the number of paths from (0, 0), the top-left
// corner, to (R, C), the bottom-right corner, and the only two movement options
// are moving right and moving down.

package moe.ijnji.epi;



public class NumberWays {

  public static int numberOfWays(int r, int c) {
    if (r == 0 || c == 0) return 1;
    int[][] memo = new int[r][c];
    for (int i = 0; i < r; i++) memo[i][0] = 1;
    for (int j = 0; j < c; j++) memo[0][j] = 1;
    for (int i = 1; i < r; i++) {
      for (int j = 1; j < c; j++) {
        memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
      }
    }
    return memo[r - 1][c - 1];
  }

  private static void smallTest() {
    //expect(numberOfWays(0, 0)).toBe(1);
    //expect(numberOfWays(1, 1)).toBe(1);
    //expect(numberOfWays(2, 2)).toBe(2);
    //expect(numberOfWays(1, 5)).toBe(1);
    //expect(numberOfWays(5, 1)).toBe(1);
    //expect(numberOfWays(4, 3)).toBe(10);
    //expect(numberOfWays(5, 5)).toBe(70);
  }

  public static void main(String[] args) {
    smallTest();
  }

}
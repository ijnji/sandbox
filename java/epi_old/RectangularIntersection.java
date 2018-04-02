// Description:
//
// Return whether or not two rectangles objects have a nonempty intersection.
// If so, return a rectangle of the intersection.

package epi;

import java.lang.Math;
import static rlib.TestingUtils.expect;

public class RectangularIntersection {

  public static class Rectangle {

    public int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }

  }

  public static Rectangle intersects(Rectangle A, Rectangle B) {
    int width = Math.min(A.x + A.width, B.x + B.width) - Math.max(A.x, B.x);
    int height = Math.min(A.y + A.height, B.y + B.height) - Math.max(A.y, B.y);
    if (width <= 0) return null;
    if (height <= 0) return null;
    int x = Math.min(A.x + A.width, B.x + B.width) - width;
    int y = Math.min(A.y + A.height, B.y + B.height) - height;
    return new Rectangle(x, y, width, height);
  }

  private static boolean check(Rectangle A, Rectangle B) {
    if (A == null && B == null) return true;
    if (A.x != B.x) return false;
    if (A.y != B.y) return false;
    if (A.width != B.width) return false;
    if (A.height != B.height) return false;
    return true;
  }

  private static void smallTest() {
    Rectangle A, B, result, expected;

    A = new Rectangle(0, 0, 4, 4);
    B = new Rectangle(1, 1, 5, 5);
    result = intersects(A, B);
    expected = new Rectangle(1, 1, 3, 3);
    expect(check(result, expected)).toBe(true);

    A = new Rectangle(0, 0, 2, 2);
    B = new Rectangle(4, 4, 6, 6);
    result = intersects(A, B);
    expected = null;
    expect(check(result, expected)).toBe(true);
  }

  public static void main(String[] args) {
    smallTest();
  }

}

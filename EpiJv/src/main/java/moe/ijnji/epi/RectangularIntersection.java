// Description:
//
// Return whether or not two rectangles objects have a nonempty intersection.
// If so, return a rectangle of the intersection.

package moe.ijnji.epi;

import java.lang.Math;

public class RectangularIntersection {

  public static Rectangle intersects(Rectangle A, Rectangle B) {
    int width = Math.min(A.x + A.width, B.x + B.width) - Math.max(A.x, B.x);
    int height = Math.min(A.y + A.height, B.y + B.height) - Math.max(A.y, B.y);
    if (width <= 0) return null;
    if (height <= 0) return null;
    int x = Math.min(A.x + A.width, B.x + B.width) - width;
    int y = Math.min(A.y + A.height, B.y + B.height) - height;
    return new Rectangle(x, y, width, height);
  }

}

class Rectangle {

  public int x, y, width, height;

  public Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

}

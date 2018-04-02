package moe.ijnji.epi;

import static org.junit.Assert.*;
import org.junit.Test;

public class RectangularIntersectionTest {

    private static boolean check(Rectangle A, Rectangle B) {
      if (A == null && B == null) return true;
      if (A.x != B.x) return false;
      if (A.y != B.y) return false;
      if (A.width != B.width) return false;
      if (A.height != B.height) return false;
      return true;
    }

    @Test
    public void testSimple() {
        Rectangle A, B, result, expected;

        A = new Rectangle(0, 0, 4, 4);
        B = new Rectangle(1, 1, 5, 5);
        result = RectangularIntersection.intersects(A, B);
        expected = new Rectangle(1, 1, 3, 3);
        assertTrue(check(result, expected));

        A = new Rectangle(0, 0, 2, 2);
        B = new Rectangle(4, 4, 6, 6);
        result = RectangularIntersection.intersects(A, B);
        expected = null;
        assertTrue(check(result, expected));
    }
}

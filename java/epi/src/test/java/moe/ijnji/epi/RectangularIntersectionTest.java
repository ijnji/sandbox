package moe.ijnji.epi;

import org.junit.Test;
import static moe.ijnji.epi.RectangularIntersection.intersects;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
        result = intersects(A, B);
        expected = new Rectangle(1, 1, 3, 3);
        assertThat(check(result, expected), is(true));

        A = new Rectangle(0, 0, 2, 2);
        B = new Rectangle(4, 4, 6, 6);
        result = intersects(A, B);
        expected = null;
        assertThat(check(result, expected), is(true));
    }
}

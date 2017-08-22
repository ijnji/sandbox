package rlib;

public class TestingUtils {

  public static class Expectation {

    private Object result;

    public Expectation(Object result) {
      this.result = result;
    }

    public void toBe(Object reference) {
      if (reference == null) {
        if (this.result == null) return;
        else {
          System.out.printf("Expected %s to be \"%s\".\n", this.result.toString(), "null");
        }
      } else {
        if (reference.equals(this.result)) return;
        else {
          System.out.printf("Expected %s to be \"%s\".\n", "null", reference.toString());
        }
      }
    }

    public void toNotBe(Object reference) {
      if (reference == null) {
        if (this.result != null) return;
        else {
          System.out.printf("Expected %s to not be \"%s\".\n", this.result.toString(), "null");
        }
      } else {
        if (!reference.equals(this.result)) return;
        else {
          System.out.printf("Expected %s to not be \"%s\".\n", "null", reference.toString());
        }
      }
    }

  }

  public static Expectation expect(Object result) {
    return new Expectation(result);
  }

}

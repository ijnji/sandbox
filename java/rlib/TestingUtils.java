package rlib;

public class TestingUtils {

  public static class Expectation {

    private Object result;

    public Expectation(Object result) {
      this.result = result;
    }

    public void toBe(Object reference) {
      if (!this.result.equals(reference)) {
        System.out.printf("Expected \"%s\" to be \"%s\".\n",
          this.result.toString(), reference.toString());
      }
    }

    public void toNotBe(Object reference) {
      if (this.result.equals(reference)) {
        System.out.printf("Expected \"%s\" to not be \"%s\".\n",
          this.result.toString(), reference.toString());
      }
    }

  }

  public static Expectation expect(Object result) {
    return new Expectation(result);
  }

}
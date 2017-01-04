import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class UniqueChar {
  public static void main(String[] args) {
    List<String> testList = new ArrayList<>();
    testList.add("");
    testList.add("a");
    testList.add("aaa");
    testList.add("The New York Times: Find breaking news, multimedia, reviews & opinion on Washington, business, sports, movies, travel, books, jobs, education, real estate, cars & more at nytimes.com.");
    testList.add("こんいちは");
    testList.add("こんいちはこんいちは");
    // TODO: Update function to use unicode codepoints.
    // The following 4-byte UTF-16 symbols have the same first 2 bytes, and incorrectly fails.
    testList.add("𝄐𝄑");

    for (String s : testList) {
      System.out.println(Boolean.toString(isUniqueA(s)) + ": \"" + s + "\"");
    }
  }

  private static boolean isUniqueA(String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char ci = s.charAt(i);
      if (!set.contains(ci)) {
        set.add(ci);
      } else {
        return false;
      }
    }
    return true;
  }
}
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        ArrayList<String> in = new ArrayList<>();
        in.add("aaaaaaaaaaaaaa");
        in.add("The New York Times: Find breaking news, multimedia, reviews & opinion on Washington, business, sports, movies, travel, books, jobs, education, real estate, cars & more at nytimes.com.");
        in.add("b");
        in.add("abcdeig");
        in.add("こんいちは！");
        in.add("こんいちはこんいちは");
        
        for (int i = 0; i < in.size(); ++i) {
            System.out.print("Case #" + Integer.toString(i) + ": ");
            // Use the following solution.
            boolean uniq = isUniqueA(in.get(i));
            System.out.print(Boolean.toString(uniq));
            System.out.println();
        }
    }
    
    private static boolean isUniqueA(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            String subs = s.substring(i, i + 1);
            if (!set.contains(subs)) {
                set.add(subs);
            } else {
                return false;
            }
        }
        return true;
    }
}
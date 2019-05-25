// Description:
//
// Given two integers as lists, multiply them.

package moe.ijnji.epi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntAsListMultiply {

    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        boolean isNeg = false;
        if (num1.get(0) < 0 ^ num2.get(0) < 0)
            isNeg = true;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));
        Collections.reverse(num1);
        Collections.reverse(num2);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < num1.size() + num2.size(); i++)
            ans.add(0);
        for (int i = 0; i < num1.size(); i++) {
            int carry = 0;
            for (int j = 0; j < num2.size(); j++) {
                int res = num1.get(i) * num2.get(j) + carry + ans.get(i + j);
                int d = res % 10;
                carry = res / 10;
                ans.set(i + j, d);
            }
            int j = num2.size();
            while (carry > 0) {
                int res = carry + ans.get(i + j);
                int d = res % 10;
                carry = res / 10;
                ans.set(i + j, d);
                j++;
            }
        }
        Collections.reverse(ans);
        while (ans.get(0) == 0 && ans.size() > 1)
            ans.remove(0);
        if (isNeg)
            ans.set(0, ans.get(0) * -1);
        return ans;
    }

}
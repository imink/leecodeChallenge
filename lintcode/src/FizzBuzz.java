/**
 * https://leetcode.com/problems/fizz-buzz
 * Created by imink on 09/03/2017.
 */
import java.util.*;
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) res.add("FizzBuzz");
            else if (i % 5 == 0) res.add("Buzz");
            else if (i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz");
            else res.add(Integer.toString(i));
        }
        return res;
    }
}

/**
 * http://www.lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/
 * Created by imink on 04/03/2017.
 */
import java.util.*;

public class LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) return 0;

        Map<Character, Integer> hashMap = new HashMap<>();

        int left = 0, right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, hashMap.get(c) + 1);
            }
            // why greater than k
            while (hashMap.size() > k) {
                char c2 = s.charAt(left);

                if (hashMap.containsKey(c2)) {
                    if (hashMap.get(c2) == 1) {
                        hashMap.remove(c2);
                    } else {
                        hashMap.put(c2, hashMap.get(c2) - 1);
                    }
                }
                left++;
            }
            right++; // use while not for, so right already increase by one
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

}

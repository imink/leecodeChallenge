import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Created by imink on 08/02/2017.
 */
// TODO: 05/03/2017 今晚
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] array = new int[256];
        int left = 0, right = 0;
        int counter = 0;
        int maxLen = 1;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (array[c] > 0) {
                counter++;
            }
            array[c]++;
            // at least one duplicate
            while (counter >= 1) {
                if (array[s.charAt(left)] > 1) {
                    counter--;
                    array[s.charAt(left)]--;
                } else {
                    array[s.charAt(left)]--; // reset the numbers that behind the left pointer
                }
                maxLen = Math.max(maxLen, right - left);
                left++;
            }
            right ++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringII(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }



    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("au"));
    }
}


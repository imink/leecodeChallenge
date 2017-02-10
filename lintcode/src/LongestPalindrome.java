import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.util.HashSet;

/**
 * Created by imink on 10/02/2017.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> hashSet = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (hashSet.contains(s.charAt(i))) {
                hashSet.remove(s.charAt(i));
                counter ++;
            } else {
                hashSet.add(s.charAt(i));
            }
        }
        if (!hashSet.isEmpty()) return counter * 2 + 1;
        else return counter * 2;
    }
}

/**
 * https://leetcode.com/problems/valid-palindrome/
 * Created by imink on 09/01/2017.
 */
import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.util.*;
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();
        while (l < r) {
            while (!isValid(s.charAt(l)) && l < r) {
                l ++;
            }
            while (!isValid(s.charAt(r)) && l < r) {
                r --;
            }
            if (l == r) return true;
            else if (s.charAt(l) != s.charAt(r)) return false;
//            System.out.println(s.charAt(l) + " " + s.charAt(r));
            l ++;
            r --;
        }
        return true;
    }

    private static boolean isValid(char c) {
        if (Character.isDigit(c) || Character.isLetter(c)) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("012210"));
    }

}

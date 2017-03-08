import java.util.HashMap;
import java.util.Hashtable;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * Created by imink on 15/12/2016.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0) return null;
        if (t.length() == 0) return s;
        String res = "";
        int targetLength = t.length();
        int[] targetArray = new int[256];
        int sourceLength = 0;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < targetLength; i ++) {
            targetArray[t.charAt(i)] ++;
        }
        /**
         * i, j are two pointers, first use i to extends its right edge,
         * then use j to shrink to right, cut those unnecessary ones.
         * the most tricky part is record the existence of each letter.
         */
        int j = 0;

        for (int i = 0; i < s.length(); i ++) {
            if (targetArray[s.charAt(i)] > 0) {
                sourceLength ++;
            }
            // mark as read for all letters
            targetArray[s.charAt(i)] --;
            // loop to find the left mark, the found subString is greater or equal than current one.
            while (sourceLength >= targetLength) {
                int curLen = i - j + 1;
                // get current min
                if (curLen < max) {
                    res = s.substring(j, i+1);
                    max = curLen;
                }
                // the unnecessary letter has no effect, so we can move j to right.
                targetArray[s.charAt(j)] ++;
                if (targetArray[s.charAt(j)] > 0) {
                    sourceLength --;
                }
                j ++;
            }
        }
        return res;
    }
}

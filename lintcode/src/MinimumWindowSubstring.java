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
        // TODO: 15/12/2016 what if we use hashtable, how to make it simple
        for (int i = 0; i < targetLength; i ++) {
            targetArray[t.charAt(i)] ++;
        }
        int j = 0;

        for (int i = 0; i < s.length(); i ++) {
            if (targetArray[s.charAt(i)] > 0) {
                sourceLength ++;
            }
            // mark as read
            targetArray[s.charAt(i)] --;
            // loop to find the left mark
            while (sourceLength >= targetLength) {
                int curLen = i - j + 1;
                // get current min
                if (curLen < max) {
                    res = s.substring(j, i+1);
                    max = curLen;
                }
                // TODO: 15/12/2016 IMPORTANT HERE
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

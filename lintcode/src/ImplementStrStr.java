/**
 * https://leetcode.com/problems/implement-strstr/
 * Created by imink on 09/01/2017.
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) return -1;
        if (needle.isEmpty()) return 0;

        int start = -1, j = 0, k = 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i ++) {
            // reset
            j = 0;
            start = -1;
            k = i;
            if (haystack.charAt(i) == needle.charAt(j)) {
                start = k;
                k ++;
                j ++;
                while (k < haystack.length() && j < needle.length() && haystack.charAt(k) == needle.charAt(j)) {
                    k ++;
                    j ++;
                }
                if (j == needle.length()) return start;
            }
        }
        return -1;
    }
    // Counter-intuitive method, break the loop if you don't find one.
    public int strStrII(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "sippj"));
    }
}

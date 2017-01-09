/**
 * https://leetcode.com/problems/implement-strstr/
 * Created by imink on 09/01/2017.
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty() && haystack.isEmpty()) return 0;
//        if (needle == null || needle.length() < 1) return -1;
//        if (haystack == null || haystack.length() < 1) return -1;
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        int i = 0, j = 0, start = -1;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j) && start == -1) {
                start = i;
                i ++;
                j ++;
            } else if (haystack.charAt(i) == needle.charAt(j) && start != -1) {
                i ++;
                j ++;
            } else if (haystack.charAt(i) != needle.charAt(j)) {
                start = -1;
                i ++;
                j = 0;
            }
        }
        if (j == needle.length()) return start;
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
}

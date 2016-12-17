/**
 * https://leetcode.com/problems/length-of-last-word/
 * Created by imink on 17/12/2016.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0 || s == null) return 0;
        int i = 0;
        int j = s.length() - 1;
        while ((s.charAt(i) == ' ' || s.charAt(j) == ' ') && j > i) {
            if (s.charAt(i) == ' ') i ++;
            else if (s.charAt(j) == ' ') j --;
        }
        if (j == i && s.charAt(i) == ' ') return 0;
        if (j == i && s.charAt(i) != ' ') return 1;
        int t = j;
        while (j - i > 0) {
            j --;
            if(s.charAt(j) == ' ') return t - j;
            //if(j == i) return t - i + 1
        }

        return t - j + 1;
    }
}

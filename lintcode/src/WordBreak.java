/**
 * https://leetcode.com/problems/word-break/?tab=Solutions
 * Created by imink on 07/02/2017.
 */
import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        if (wordDict.size() == 0) return false;

        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;

        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (flag[j] && wordDict.contains(s.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
}

/**
 * https://leetcode.com/problems/generate-parentheses/
 * Created by imink on 16/02/2017.
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n == 0) return null;
        List<String> list = new ArrayList<String>();
        create(list, "", 0, 0, n);
        return list;
    }

    public void create(List<String> list, String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            list.add(str);
            return;
        }
        if (open < n) {
            String openStr = str + "(";
            create(list, openStr, open + 1, close, n);
        }
        if (close < open) {
            String closeStr = str + ")";
            create(list, closeStr, open, close + 1, n);
        }
    }
}

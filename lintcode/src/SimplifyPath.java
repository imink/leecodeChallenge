import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/
 * Created by imink on 20/12/2016.
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        if (path.length() <= 0) return null;
        Stack<String> stack = new Stack<>();
        stack.add("/");
        boolean startTag = false;
        StringBuilder curString = new StringBuilder();
        for (int i = 0; i < path.length(); i ++) {
            if (!startTag && path.charAt(i) == '/') {
                startTag = true;
            }
            else if (startTag && path.charAt(i) != '/') curString.append(path.charAt(i));
            else if ((startTag && path.charAt(i) == '/')) {
                if (curString.toString().equals("..")) {
                    if (stack.size() > 1) stack.pop();
                } else if (curString.toString().equals(".")) {

                }
                else stack.add(curString.toString());
                curString = new StringBuilder();
            }
            else if (startTag && i == path.length() - 1) {
                stack.add(curString.toString());
            }
        }
        curString = new StringBuilder();
        for (int i = 0; i < stack.size(); i ++) {
            curString.append(stack.get(i));
            if (i > 0 && i < stack.size()) curString.append("/");
        }
        return curString.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/...."));
    }
}

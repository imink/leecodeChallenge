
/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Created by imink on 08/01/2017.
 */
import java.util.*;
public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        if (s == null || s.length() < 1) return "";
        String[] array;
        StringBuilder sb = new StringBuilder();
        // TODO: 08/01/2017 split() source code
        array = s.split(" ");
        if (array.length < 1) return "";

        for (int i = array.length - 1; i >= 0; i --) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.print(reverseWords(" 1"));
        System.out.print("XXXXX");
    }

}

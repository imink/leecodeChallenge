/**
 * https://leetcode.com/problems/add-binary/
 * Created by imink on 27/12/2016.
 */
import java.util.*;
public class addBinary {
    private String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        String res = "";

        if (a.length() > b.length()) {
            res = add(a, b, res);
        } else {
            res = add(b, a, res);
        }

//        System.out.print(res);
        return res;
    }

    public String add(String large, String small, String res) {
        int i = 0;
        boolean flag = false;
        char t;
        char l, s;
        while (i < small.length()) {
            l = large.charAt(large.length() - i - 1);
            s = small.charAt(small.length() - i - 1);
            if (flag) {
                if (l != '1') {
                    t = '1';
                    flag = false;
                } else {
                    t = '0';
                }
            } else {
                t = l;
            }
            if (t == '1' && s == '1') {
                res = '0' + res;
                flag = true;
            } else {
                char temp = t == s ? '0' : '1';
                res = temp + res;
            }
            i ++;
        }
//                System.out.println(res);

        while (i < large.length()) {
            t = large.charAt(large.length() - i - 1);
            if (flag && t == '1') {
                t = '0';
            } else if (flag && t == '0') {
                t = '1';
                flag = false;
            }
            res = t + res;
            i ++;
        }
        if (flag) res = '1' + res;
        return res;
    }

    public static void main(String[] args) {
        addBinary add = new addBinary();
        System.out.println(add.addBinary("101111", "10"));
        System.out.println(4/2);
    }
}

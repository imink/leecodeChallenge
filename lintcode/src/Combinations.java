/**
 * https://leetcode.com/problems/combinations/
 * Created by imink on 29/12/2016.
 */
import java.lang.reflect.Array;
import java.util.*;
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= k; i ++) {
            res = dp(res, n, k);
        }
        return res;
    }

    public static List<List<Integer>> dp(List<List<Integer>> res, int n, int k) {
        if (res.size() <= 0) {
            for (int i = 1; i <= n; i ++) {
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(i);
                res.add(sub);
            }
        } else {
            for (ListIterator<List<Integer>> iterator = res.listIterator(); iterator.hasNext();) {
                List<Integer> subList = iterator.next();
//            if (subList.size() >= k) break;
                int sp = subList.get(subList.size() - 1);
                if (sp + 1 > n) {
                    iterator.remove();
                } else {
                    iterator.remove();
                    for (int i = sp + 1; i <= n; i ++) {
                        List<Integer> temp = new ArrayList<Integer>(subList);
                        temp.add(i);
                        iterator.add(temp);
                    }
                }
            }
        }

        return res;
    }

    public static void printList(List<List<Integer>> list) {
        for (List<Integer> subList: list) {
            for (Integer i: subList) {
                System.out.print(i);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list = combine(20, 16);
        printList(list);
    }

}

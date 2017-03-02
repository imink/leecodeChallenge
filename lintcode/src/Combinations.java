/**
 * https://leetcode.com/problems/combinations/
 * Created by imink on 29/12/2016.
 */
import java.lang.reflect.Array;
import java.util.*;
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combine(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    public static void combine(List<List<Integer>> res, List<Integer> comb, int start, int n, int k) {
        // no num left
        if (k == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = start; i <= n; i ++) {
            comb.add(i); // increase add the num
            combine(res, comb, i + 1, n, k - 1); // DFS to its deepest
            comb.remove(comb.size() - 1); // remove the last added num
        }
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

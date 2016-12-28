/**
 * https://leetcode.com/problems/permutation-sequence/
 * Created by imink on 20/12/2016.
 */
import java.util.*;
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        if (n <= 0) return null;
        int size = 1, i = 1;
        String res = "";
        k = k -1;
        ArrayList<Integer> array = new ArrayList<>();
        while (i <= n) {
            size = size * i;
            array.add(i);
            i ++;
        }
        if (k >= size || k < 0) return null;


        while (array.size() > 0) {
            int p = k / (size / n);
            res = res + array.get(p);
            array.remove(p);
            k = k % (size / n);
            size = size / n;
            n --;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(getPermutation(n,k));
    }
}

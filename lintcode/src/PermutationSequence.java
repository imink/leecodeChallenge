/**
 * https://leetcode.com/problems/permutation-sequence/
 * Created by imink on 20/12/2016.
 */
import java.util.*;
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];

        k = k - 1;
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }

        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k = k % factor;
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (index == 0) {
                        used[j] = true;
                        sb.append((char) ('0' + j + 1));
                        System.out.println(sb);
                        break;
                    } else {
                        index--;
                    }
                }
            }
            if (i < n - 1) {
                factor = factor / (n - 1 - i);
            }
        }

        return sb.toString();
    }
//    public void insert(PriorityQueue pq, int i) {
//        if (pq.size() == 0) pq.offer(i);
//        else {
//            int head = (Integer)pq.peek();
//            int len = (head / 10) + 2;
//            for (int j = 1; j <= len;  j++) {
//                int val = head * 10 * i;
//                pq.offer(head);
//            }
//
//        }
//    }

    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println(getPermutation(n,k));
    }
}

/**
 * LintCode 397
 * http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence/
 * Created by imink on 20/11/2016.
 */
public class LongestIncreasingContinuousSubsequence {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        int n = A.length;
        int res = 0;
        int asc = 1, des = 1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        for(int i = 0; i < n - 1; i ++) {
            if (A[i] < A[i + 1]) {
                asc = asc + 1;
                des = 1;
            }
            if (A[i] > A[i + 1]) {
                des = des + 1;
                asc = 1;
            }
            res = Math.max(res, Math.max(asc, des));
        }

        return res;
    }
}

import java.util.Vector;

/**
 * https://leetcode.com/problems/perfect-squares/
 * Created by imink on 07/03/2017.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        if (n < 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int min;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            min = Integer.MAX_VALUE;
            while (i - j * j >= 0) {
                min = Math.min(dp[i - j * j] + 1, min);
                j++;
            }
            dp[i] = min;// get the min for current value
        }
        return dp[n];
    }
}


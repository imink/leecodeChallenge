/**
 * https://leetcode.com/problems/climbing-stairs/
 * Created by imink on 14/02/2017.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    public static void main(String[] args[]) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(3));
    }
}

/**
 * https://leetcode.com/problems/unique-paths/
 * Created by imink on 17/12/2016.
 */
import java.util.*;
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int res = 0;
        int[][] dp = new int[m][n];
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 && n == 1) return 1;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        res = dp[m - 1][n - 1];
        return res;
    }
}

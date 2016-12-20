/**
 * https://leetcode.com/problems/unique-paths-ii/
 * Created by imink on 18/12/2016.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int res = 0;
        boolean m0 = false, n0 = false;
        if (obstacleGrid == null || obstacleGrid[0] == null) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 && n == 1 && obstacleGrid[0][0] == 1) return 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (obstacleGrid[i][j] == 1) m0 = true;
                    if (m0) dp[i][j] = 0;
                    else dp[i][j] = 1;
                    //System.out.println(dp[i][j]);
                }
                if (j == 0) {
                    if (obstacleGrid[i][j] == 1) n0 = true;
                    if (n0) dp[i][j] = 0;
                    else dp[i][j] = 1;
                }
                if (i != 0 && j != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
            }
        }
        res = dp[m - 1][n - 1];
        return res;
    }
}

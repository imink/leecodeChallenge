/**
 * https://leetcode.com/problems/maximal-rectangle/
 * Created by imink on 02/01/2017.
 */
import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[][] height = new int[n][m];

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (i == 0)
                    height[i][j] = ((matrix[i][j] == '1') ? 1 : 0);
                else
                    height[i][j] = ((matrix[i][j] == '1') ? height[i-1][j] + 1 : 0);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i ++) {
            Stack<Integer> S = new Stack<>();
            for (int j = 0; j < m; j ++) {
                while(!S.empty() && height[i][j] < height[i][S.peek()]) {
                    int pos = S.pop();
                    int width = S.empty() ? j : j - S.peek() - 1;
                    res = Math.max(res, height[i][pos] * width);
                }
                S.push(j);
            }
            while(!S.empty()) {
                int pos = S.pop();
                int width = S.empty() ? m : m - S.peek() - 1 ;
                res = Math.max(res, height[i][pos] * width);
            }
        }

        return res;
    }
}

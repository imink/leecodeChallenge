/**
 *
 * http://www.geeksforgeeks.org/find-number-of-islands/
 * http://www.jiuzhang.com/solutions/number-of-islands/
 * Created by imink on 02/11/2016.
 */
public class NumberOfIslands {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    private int m, n;

    // have to traverse all the surrounding grid.
    public void dfs(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j]) {
            grid[i][j] = false;
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }


    public int numIslands(boolean[][] grid) {
        // Write your code here
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;
        int counter = 0;
        for (int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                // includes all the visited and negative value
                if (!grid[i][j]) continue;
                counter ++;
                dfs(grid, i, j);
            }
        }
        return counter;
    }

}

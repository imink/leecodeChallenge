import java.util.ArrayList;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Created by imink on 27/12/2016.
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        if (n <= 0) return new int[n][n];
        if (n == 1) return new int[][] {{1}};
        int rowLen = n, colLen = n;
        int res[][] = new int[n][n]; // default is 0
        int flag = 1;
        int x = 1, col = 0, row = 0;
        int index = 0;
        while (true) {
            if (flag == 1) {
                index = 0;
                while (index < colLen) {
                    res[row][col + index] = x;
                    x ++;
                    index ++;
                }
                flag = 2;
                rowLen --;
                row ++;
                col = col + index - 1;
            }
            else if (flag == 2) {
                index = 0;
                while (index < rowLen) {
                    res[row + index][col] = x;
                    index ++;
                    x ++;
                }
                flag = 3;
                col --;
                colLen --;
                row = row + index - 1;
            }
            else if (flag == 3) {
                index = 0;
                while (index < colLen) {
                    res[row][col - index] = x;
                    x ++;
                    index ++;
                }
                flag = 4;
                rowLen --;
                row --;
                col = col - index + 1;
            }
            else if (flag == 4) {
                index = 0;
                while (index < rowLen) {
                    res[row - index][col] = x;
                    x ++;
                    index ++;
                }
                flag = 1;
                colLen --;
                col ++;
                row = row - index + 1;
            }
            if (x > n * n) return res;
        }
    }


    public static void main(String[] args) {
        int[][] res = generateMatrix(1);

        for (int i = 0; i < res.length; i ++) {
            for (int j = 0; j < res[0].length; j ++) {
                System.out.println(res[i][j]);
            }
        }
    }
}

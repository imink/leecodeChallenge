/**https://leetcode.com/problems/search-a-2d-matrix/#/description
 * Created by imink on 15/03/2017.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        int i = 0;
        int j = n;
        int row = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target >= matrix[mid][0]) {
                i = mid;
            } else if (target < matrix[mid][0]) {
                j = mid - 1;
            }
        }
        row = j;
        i = 0;
        j = m;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target > matrix[row][mid]) {
                i = mid + 1;
            } else if (target < matrix[row][mid]) {
                j = mid - 1;
            } else if (target == matrix[row][mid]) {
                return true;
            }
        }

        return false;
    }

    public boolean searchMatrixIMP(int[][] matrix, int target) {

        return false;
    }
}
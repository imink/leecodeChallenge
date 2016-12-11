/**
 * https://leetcode.com/problems/search-insert-position/
 * Created by imink on 11/12/2016.
 */
public class SearchInsertPosition {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col - 1;
        //System.out.println(row + " " + col);

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (target == matrix[mid/col][mid%col]) return true;
            if (target == matrix[start/col][start%col]) return true;
            if (target == matrix[end/col][end%col]) return true;
            if (target < matrix[mid/col][mid%col]) {
                end = mid;
            } else if (target > matrix[mid/col][mid%col]) {
                start = mid;
            }
        }
        if (target == matrix[start/col][start%col]) return true;
        else if (target == matrix[end/col][end%col]) return true;

        return false;
    }
}

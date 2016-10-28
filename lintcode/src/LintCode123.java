/**
 * Word Search
 * http://www.lintcode.com/en/problem/word-search/
 * http://www.jiuzhang.com/solutions/word-search/
 * Created by imink on 27/10/2016.
 */
public class LintCode123 {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public boolean exist(char[][] board, String word) {

        int index = 1;
        if (board.length == 0 || word.length() ==0) {
            return false;
        }


        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (board[i][j] == word.charAt(0) && word.length() > 1) {
                    for (int k = 0; k < 4; k ++) {
                        if (!gridSearch(board, i + dx[i], j + dy[j], word, index, i, j)) {
                            break;
                        } else {
                            return true;
                        }
                    }
                }
                if (board[i][j] == word.charAt(0) && word.length() == 1) {
                    return true;
                }

            }
        }

        return true;
    }

    public boolean gridSearch(char[][] board, int x, int y, String word, int index, int lastX, int lastY) {


        if (board[x][y] == word.charAt(index)) {
            if (index == word.length() - 1) {
                return true;
            }
            for (int i = 0; i < 4; i ++) {
                if (!(x + dx[i] == lastX && y + dy[i] == lastY)) {
                    gridSearch(board, x + dx[i], y + dy[i], word, index + 1, x, y);
                }
            }
            return false;
        } else {
            return false;
        }
    }
}

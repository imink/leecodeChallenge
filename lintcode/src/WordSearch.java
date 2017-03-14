/**
 * Word Search
 * http://www.lintcode.com/en/problem/word-search/
 * http://www.jiuzhang.com/solutions/word-search/
 * Created by imink on 27/10/2016.
 */
public class WordSearch {


    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public boolean exist(char[][] board, String word) {
        // edge case
        if (word.length() == 0) return true;
        if (board == null || board.length == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, 0, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    // how we could find out those already visited cell
    public boolean dfs(char[][] board, int start, String word, int i, int j) {
        // if not match, return false
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(start)) {
            return false;
        }
        // check the last char
        if (board[i][j] == word.charAt(start) && start == word.length() - 1) {
            return true;
        }
        // TODO: 10/03/2017 why we cannot use this?
//        for (int p = 0; p < 4; p++) {
//            // only if one possible is true, return true;
//            if (dfs(board, start + 1, word, i + dx[i], j + dy[i])) {
//                return true;
//            }
//        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean exist = dfs(board, start + 1, word, i + 1, j) ||
                        dfs(board, start + 1, word, i, j + 1) ||
                        dfs(board, start + 1, word, i - 1, j) ||
                        dfs(board, start + 1, word, i, j - 1);
        board[i][j] = temp;
        return exist;
    }



}

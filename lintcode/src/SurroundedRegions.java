import java.util.*;
/**
 * https://leetcode.com/problems/surrounded-regions/
 * Created by imink on 05/12/2016.
 */
public class SurroundedRegions {
    class Cell {
        int _x;
        int _y;
        Cell(int x, int y) {
            this._x = x;
            this._y = y;
        }
    }


    public void solve(char[][] board) {
        Stack<Cell> nextCell = new Stack<>();
        Stack<Cell> visitedCell = new Stack<>();
        Stack<Cell> damagedCell = new Stack<>();

        int row = board.length;
        int col = 0;
        if (row > 0) {
            col = board[0].length;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean flag = true;

        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == row - 1 || j == col - 1)) {
                    board[i][j] = 'D';
                    damagedCell.push(new Cell(i, j));
                }
            }
        }


        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (board[i][j] == 'O') {
                    nextCell.push(new Cell(i, j));
                    while (!nextCell.empty()) {
                        flag = true;
                        Cell curCell = nextCell.pop();
                        int n = curCell._x;
                        int m = curCell._y;
                        for (int q = 0; q < 4; q ++) {
                            int dn = n + dx[q];
                            int dm = m + dy[q];

                            if (dn < 0 || dn > row - 1 || dm < 0 || dm > col - 1) {
                                continue;
                            }
                            if (board[dn][dm] == 'V') continue;

                            if (board[dn][dm] == 'D') {
                                if (board[n][m] != 'D') {
                                    board[n][m] = 'D';
                                    damagedCell.push(new Cell(n, m));
                                    break;
                                }
                            } else if (board[dn][dm] == 'O') {
                                nextCell.push(new Cell(dn, dm));
                            }

                        }
                        if (board[n][m] == 'D') {
                            flag = false;
                            nextCell = new Stack<>();
                        } else {
                            board[n][m] = 'V';
                            visitedCell.push(new Cell(n, m));
                        }


                    }
                    if (flag) {
                        while (!visitedCell.empty()) {
                            Cell cell = visitedCell.pop();
                            board[cell._x][cell._y] = 'X';
                        }
                    } else {
                        while (!visitedCell.empty()) {
                            Cell cell = visitedCell.pop();
                            board[cell._x][cell._y] = 'O';
                        }
                    }

                }
            }
        }
        while (!damagedCell.empty()) {
            Cell cell = damagedCell.pop();
            board[cell._x][cell._y] = 'O';
        }

    }

    public static void main(String[] args) {
//        String[] input = {"XXXX","XOOX","XXOX","XOXX"};
        String[] input = {"OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"};
        char[][] inputChar = new char[input.length][input[0].length()];
        int i = 0;
        for (String s: input) {
            inputChar[i] = s.toCharArray();
            i = i + 1;
        }

        SurroundedRegions object = new SurroundedRegions();
        object.solve(inputChar);

        for (i = 0; i < inputChar.length; i ++) {
            System.out.println(inputChar[i]);
        }
    }
}

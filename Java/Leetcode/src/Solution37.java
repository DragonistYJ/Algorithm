/*
NO37 解数独
编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
 */
public class Solution37 {
    boolean solved;

    public void solveSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] block = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    int k = board[i][j] - '0';
                    row[i][k] = 1;
                    col[j][k] = 1;
                    block[i / 3 * 3 + j / 3][k] = 1;
                }
            }
        }
        solved = false;
        solve(0, 0, row, col, block, board);
    }

    private void solve(int r, int c, int[][] row, int[][] col, int[][] block, char[][] board) {
        if (r == 9 && c == 0) {
            solved = true;
            return;
        }

        int rt = r;
        int ct = c;
        ct += 1;
        if (ct == 9) {
            ct = 0;
            rt += 1;
        }

        if (Character.isDigit(board[r][c])) {
            solve(rt, ct, row, col, block, board);
        } else {
            for (int i = 1; i < 10; i++) {
                if (row[r][i] == 0 && col[c][i] == 0 && block[r / 3 * 3 + c / 3][i] == 0) {
                    row[r][i] = 1;
                    col[c][i] = 1;
                    block[r / 3 * 3 + c / 3][i] = 1;
                    board[r][c] = (char) ('0' + i);
                    solve(rt, ct, row, col, block, board);
                    if (solved) return;
                    board[r][c] = '.';
                    block[r / 3 * 3 + c / 3][i] = 0;
                    col[c][i] = 0;
                    row[r][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

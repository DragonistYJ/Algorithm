/**
 * @ClassName Solution130
 * @Author 11214
 * @Date 2020/6/9
 * @Description 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solution130 {
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(int x, int y, char[][] board) {
        board[x][y] = 'X';
        for (int i = 0; i < 4; i++) {
            int xx = x + directions[i][0];
            int yy = y + directions[i][1];
            if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length && board[xx][yy] == 'O') {
                dfs(xx, yy, board);
            }
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int n = board.length;
        int m = board[0].length;
        char[][] copy = new char[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, m);
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(i, 0, copy);
            if (board[i][m - 1] == 'O') dfs(i, m - 1, copy);
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') dfs(0, i, copy);
            if (board[n - 1][i] == 'O') dfs(n - 1, i, copy);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && copy[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        new Solution130().solve(board);
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}

/*
NO79 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Solution79 {
    private char[][] board;
    private boolean[][] used;
    private String word;
    private boolean ans;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int n;
    private int m;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.ans = false;
        n = board.length;
        m = board[0].length;
        this.used = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (this.board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    dfs(i, j, 1);
                    used[i][j] = false;
                }
                if (ans) return ans;
            }
        }
        return ans;
    }

    public void dfs(int x, int y, int step) {
        if (step == word.length()) {
            ans = true;
            return;
        }

        if (ans) return;

        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !used[nx][ny] && board[nx][ny] == word.charAt(step)) {
                used[nx][ny] = true;
                dfs(nx, ny, step + 1);
                used[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Solution79().exist(board, "ABCB"));
    }
}

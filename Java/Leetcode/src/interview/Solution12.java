package interview;

/**
 * @ClassName Solution12
 * @Author 11214
 * @Date 2020/4/13
 * @Description TODO
 */
public class Solution12 {
    private int n;
    private int m;
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean dfs(boolean[][] visited, char[][] board, String word, int step, int x, int y) {
        if (step == word.length()) return true;
        for (int i = 0; i < 4; i++) {
            int xx = x + directions[i][0];
            int yy = y + directions[i][1];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && !visited[xx][yy] && board[xx][yy] == word.charAt(step)) {
                visited[xx][yy] = true;
                if (dfs(visited, board, word, step + 1, xx, yy)) return true;
                visited[xx][yy] = false;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        n = board.length;
        m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(visited, board, word, 1, i, j)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new Solution12().exist(board, "ABCCED"));
    }
}

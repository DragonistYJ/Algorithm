/*
NO36 有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    int k = board[i][j] - '0';
                    if (row[i][k] || col[j][k] || box[i / 3 * 3 + j / 3][k]) return false;
                    row[i][k] = true;
                    col[j][k] = true;
                    box[i / 3 * 3 + j / 3][k] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

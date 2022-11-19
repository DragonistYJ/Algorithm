import java.util.Arrays;

/**
 * @author yujian
 * @since 2022/9/7 16:00
 * 现有一个 n x n 大小的网格，左上角单元格坐标 (0, 0) ，右下角单元格坐标 (n - 1, n - 1) 。
 * 给你整数 n 和一个整数数组 startPos ，其中 startPos = [startrow, startcol] 表示机器人最开始在坐标为 (startrow, startcol) 的单元格上。
 * 另给你一个长度为 m 、下标从 0 开始的字符串 s ，其中 s[i] 是对机器人的第 i 条指令：'L'（向左移动），'R'（向右移动），'U'（向上移动）和 'D'（向下移动）。
 * 机器人可以从 s 中的任一第 i 条指令开始执行。它将会逐条执行指令直到 s 的末尾，但在满足下述条件之一时，机器人将会停止：
 * 下一条指令将会导致机器人移动到网格外。
 * 没有指令可以执行。
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是机器人从第i条指令开始，可以执行的指令数目 。
 */
public class Solution2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x = startPos[0];
            int y = startPos[1];
            for (int j = i; j < m; j++) {
                if (s.charAt(j) == 'L') {
                    y -= 1;
                } else if (s.charAt(j) == 'R') {
                    y += 1;
                } else if (s.charAt(j) == 'U') {
                    x -= 1;
                } else {
                    x += 1;
                }
                if (0 <= x && x < n && 0 <= y && y < n) {
                    ans[i] += 1;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2120 solution2120 = new Solution2120();
        System.out.println(Arrays.toString(solution2120.executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
    }
}

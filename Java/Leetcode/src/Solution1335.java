import java.util.Arrays;

/*
NO1335 工作计划的最低难度
你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
 */
public class Solution1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if (d > len) return -1;

        int[][] dp = new int[d][len];
        for (int i = 0; i < d; i++) {
            Arrays.fill(dp[i], 100000000);
        }
        int[][] max = new int[len][len];
        for (int i = 0; i < len; i++) {
            max[i][i] = jobDifficulty[i];
        }
        for (int day = 1; day < len; day++) {
            for (int i = 0; i < len - day; i++) {
                int j = i + day;
                for (int k = i; k < j; k++) {
                    max[i][j] = Math.max(max[i][j], Math.max(max[i][k], max[k + 1][j]));
                }
            }
        }

        System.arraycopy(max[0], 0, dp[0], 0, len);
        for (int i = 1; i < d; i++) {
            for (int j = i; j <= len - d + i; j++) {
                for (int k = i - 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + max[k + 1][j]);
                }
            }
        }

        return dp[d - 1][len - 1];
    }

    public static void main(String[] args) {
        int[] x = {9,9,9};
        System.out.println(new Solution1335().minDifficulty(x, 3));
    }
}

/**
 * @author 11214
 * @since 2022/12/6 17:00
 * <p>
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 */
public class Solution1723 {
    public int minimumTimeRequired(int[] jobs, int k) {
        int states = 1 << jobs.length;

        int[] sum = new int[states];
        for (int i = 1; i < states; i++) {
            int zeros = Integer.numberOfTrailingZeros(i);
            sum[i] = sum[i - (1 << zeros)] + jobs[zeros];
        }

        int[][] dp = new int[k + 1][states];
        for (int i = 1; i < states; i++) {
            dp[1][i] = sum[i];
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < states; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = j; l != 0; l = (l - 1) & j) {
                    min = Math.min(min, Math.max(sum[l], dp[i - 1][j - l]));
                }
                dp[i][j] = min;
            }
        }

        return dp[k][states - 1];
    }

    public static void main(String[] args) {
        int[] jobs = new int[]{1, 2, 4, 7, 8};
        System.out.println(new Solution1723().minimumTimeRequired(jobs, 2));
    }
}

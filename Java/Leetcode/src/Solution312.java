/*
NO312 戳气球
有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
求所能获得硬币的最大数量。

说明:
你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 */
public class Solution312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] fencedNums = new int[n + 2];
        fencedNums[0] = 1;
        fencedNums[n + 1] = 1;
        System.arraycopy(nums, 0, fencedNums, 1, nums.length);
        int[][] dp = new int[n + 2][n + 2];

        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n + 2 - len; i++) {
                int j = i + len - 1;
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + fencedNums[i] * fencedNums[k] * fencedNums[j]);
                }
            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        int[] x = {3, 1, 5, 8};
        System.out.println(new Solution312().maxCoins(x));
    }
}

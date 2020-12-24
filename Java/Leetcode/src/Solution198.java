/*
NO198 打家劫舍
 */
public class Solution198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }

        for (int i = 2; i < len; i++) {
            for (int start = 0; start < len - i; start++) {
                int end = start + i;
                for (int j = start; j <= end; j++) {
                    int sum = nums[j];
                    if (j - 2 >= start) sum += dp[start][j - 2];
                    if (j + 2 <= end) sum += dp[j + 2][end];
                    dp[start][end] = Math.max(dp[start][end], sum);
                }
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] x = {2, 7, 9, 3, 1};
        System.out.println(new Solution198().rob(x));
    }
}

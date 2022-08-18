/**
 * @author 11214
 * @since 2022/8/18 15:47
 * Leetcode 213 打家劫舍2
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (n == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }

        int[][] maxes = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxes[i][i] = nums[i];
            maxes[i][(i + 1) % n] = Math.max(nums[i], nums[(i + 1) % n]);
            maxes[i][(i + 2) % n] = Math.max(nums[(i + 1) % n], nums[i] + nums[(i + 2) % n]);
        }

        for (int l = 4; l < n; l++) {
            for (int start = 0; start < n; start++) {
                int end = (start + l - 1) % n;
                for (int i = 0; i < l; i++) {
                    int sum = nums[(start + i) % n];
                    if (i >= 2) {
                        sum += maxes[start][(start + i - 2) % n];
                    }
                    if (i <= l - 2) {
                        sum += maxes[(start + i + 2) % n][end];
                    }
                    maxes[start][end] = Math.max(maxes[start][end], sum);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int start = (i - 2 + n) % n;
            int end = (i + 2) % n;
            ans = Math.max(ans, nums[i] + maxes[end][start]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        int rob = solution213.rob(new int[]{4, 1, 2, 7, 5, 3, 1});
        System.out.println(rob);
    }
}

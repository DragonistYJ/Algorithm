/*
NO53 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(nums[i], nums[i] + sum[i - 1]);
        }
        int ans = sum[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, sum[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution53().maxSubArray(x));
    }
}

/*
NO152 乘积最大子序列
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = max;
            int preMin = min;
            max = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            min = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i]));
            ans = Math.max(ans, Math.max(max, min));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {-2, 0, -1};
        System.out.println(new Solution152().maxProduct(x));
    }
}

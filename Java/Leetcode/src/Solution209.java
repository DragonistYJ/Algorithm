/**
 * @author yujian
 * @since 2022/9/8 14:36
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = nums[0];
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (sum < target) {
                end += 1;
                if (end == nums.length) {
                    break;
                }
                sum += nums[end];
            } else {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start += 1;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution209().minSubArrayLen(11, new int[]{1, 1, 1, 1}));
    }
}

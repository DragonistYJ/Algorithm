package interview;

/**
 * @ClassName Solution42
 * @Author 11214
 * @Date 2020/4/27
 * @Description TODO
 */
public class Solution42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (sums[i - 1] > 0) sums[i] = sums[i - 1] + nums[i];
            else sums[i] = nums[i];
        }
        int ans = sums[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, sums[i]);
        }
        return ans;
    }
}

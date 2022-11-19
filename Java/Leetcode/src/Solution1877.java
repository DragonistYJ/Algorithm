import java.util.*;

/**
 * @author yujian
 * @since 2022/9/5 16:38
 * 一个数对(a,b)的数对和等于a + b。最大数对和是一个数对数组中最大的数对和。
 * 比方说，如果我们有数对(1,5)，(2,3)和(4,4)，最大数对和为max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8。
 * 给你一个长度为 偶数n的数组nums，请你将nums中的元素分成 n / 2个数对，使得：
 * nums中每个元素恰好在一个数对中，且最大数对和的值最小。
 * 请你在最优数对划分的方案下，返回最小的最大数对和。
 */
public class Solution1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, nums[i] + nums[n - i - 1]);
        }
        return max;
    }
}

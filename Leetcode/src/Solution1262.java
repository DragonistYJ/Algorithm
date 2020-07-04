import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 */
public class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int mod = num % 3;

            int[] clone = dp.clone();

            if (mod == 0) {
                dp[0] = dp[0] + num;
                dp[1] = dp[1] + num;
                dp[2] = dp[2] + num;
            } else if (mod == 1) {
                dp[0] = Math.max(dp[0], clone[2] + num);
                dp[1] = Math.max(dp[1], clone[0] + num);
                dp[2] = Math.max(dp[2], clone[1] + num);
            } else {
                dp[0] = Math.max(dp[0], clone[1] + num);
                dp[1] = Math.max(dp[1], clone[2] + num);
                dp[2] = Math.max(dp[2], clone[0] + num);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(new Solution1262().maxSumDivThree(nums));
    }
}

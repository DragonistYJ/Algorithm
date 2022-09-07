import java.util.Arrays;

/**
 * @author yujian
 * @since 2022/9/7 16:12
 * 给你一个整数数组 nums 和一个整数 k 。你可以将 nums 划分成一个或多个子序列 ，使 nums 中的每个元素都恰好出现在一个子序列中。
 * 在满足每个子序列中最大值和最小值之间的差值最多为 k 的前提下，返回需要划分的 最少 子序列数目。
 * 子序列 本质是一个序列，可以通过删除另一个序列中的某些元素（或者不删除）但不改变剩下元素的顺序得到。
 */
public class Solution2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int group = 1;
        int min = nums[0];
        for (int num : nums) {
            if (num - min > k) {
                group += 1;
                min = num;
            }
        }
        return group;
    }
}

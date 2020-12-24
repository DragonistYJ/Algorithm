import java.util.HashSet;

/**
 * @ClassName Solution330
 * @Author 11214
 * @Date 2020/6/4
 * @Description 按要求补齐数组
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中
 * 使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 */
public class Solution330 {
    public int minPatches(int[] nums, int n) {
        int usedIndex = 0;
        long range = 0;
        int ans = 0;
        while (range < n) {
            long var = range + 1;
            if (usedIndex < nums.length && nums[usedIndex] <= var) {
                var = nums[usedIndex];
                usedIndex += 1;
            } else ans += 1;
            range = range + var;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 31, 33};
        System.out.println(new Solution330().minPatches(nums, 2147483647));
    }
}

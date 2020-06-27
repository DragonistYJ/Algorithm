/**
 * 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int index = 0;
        int ans = 1;
        while (index < nums.length) {
            int len = index;
            while (len + 1 < nums.length && nums[len + 1] > nums[len]) len += 1;
            ans = Math.max(ans, len - index + 1);
            index = len + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2,3,4,5,6};
        System.out.println(new Solution674().findLengthOfLCIS(nums));
    }
}

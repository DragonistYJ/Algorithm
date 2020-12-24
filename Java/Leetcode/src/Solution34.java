/*
NO34 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if (nums.length == 0) return ans;
        int left = 0;
        while (left < nums.length && nums[left] != target) {
            left += 1;
        }
        if (left == nums.length) return ans;
        int right = left;
        while (right < nums.length && nums[right] == target) {
            right += 1;
        }
        if (right >= nums.length || nums[right] != target) {
            right -= 1;
        }
        ans[0] = left;
        ans[1] = right;
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {1};
        int[] ints = new Solution34().searchRange(x, 1);
        System.out.println(ints[0] + " " + ints[1]);
    }
}

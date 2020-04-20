/*
NO35 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        while (index < nums.length && target > nums[index]) {
            index += 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 5, 6};
        System.out.println(new Solution35().searchInsert(x, 5));
    }
}

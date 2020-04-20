/*
NO154 寻找旋转排序数组中的最小值2
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
注意数组中可能存在重复的元素。
 */
public class Solution154 {
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) return nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 0, 0, 1};
        System.out.println(new Solution154().findMin(x));
    }
}

/*
NO80 删除排序数组中的重复项2
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int index = 1;
        int times = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                times += 1;
                if (times < 2) {
                    nums[index] = nums[i];
                    index += 1;
                }
            } else {
                times = 0;
                nums[index] = nums[i];
                index += 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] x = {0,0,1,1,1,1,2,3,3};
        System.out.println(new Solution80().removeDuplicates(x));
        for (int i : x) {
            System.out.print(i + " ");
        }
    }
}

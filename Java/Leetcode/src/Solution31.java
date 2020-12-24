import java.util.Arrays;

/*
NO31 下一个排列
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index -= 1;
        }

        if (index >= 0) {
            int change = nums.length - 1;
            while (change >= 0 && nums[change] <= nums[index]) {
                change -= 1;
            }
            int tmp = nums[index];
            nums[index] = nums[change];
            nums[change] = tmp;
        }
        int i = index + 1;
        int j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i += 1;
            j -= 1;
        }
    }

    public static void main(String[] args) {
        int[] x = {5, 1, 1};
        new Solution31().nextPermutation(x);
        System.out.println(Arrays.toString(x));
    }
}

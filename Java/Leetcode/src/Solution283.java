/**
 * @author 11214
 * @since 2022/12/30 14:54
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int k = nums.length;
        for (int i = 0; i < k; ) {
            if (nums[i] != 0) {
                i++;
            } else {
                for (int j = i; j < k - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[k - 1] = 0;
                k -= 1;
            }
        }
    }
}

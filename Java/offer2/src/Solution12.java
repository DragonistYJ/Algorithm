/**
 * @author 11214
 * @since 2023/3/8 16:09
 */
public class Solution12 {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (left == right) {
                return i;
            }
            left += nums[i];
            right -= nums[i + 1];
        }
        return left == right ? nums.length - 1 : -1;
    }
}

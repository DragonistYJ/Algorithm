package interview;

/**
 * @ClassName Solution16_17
 * @Author 11214
 * @Date 2020/4/16
 * @Description TODO
 */
public class Solution16_17 {
    public int maxSubArray(int[] nums) {
        int b = nums[0];
        int sum = b;
        for (int i = 1; i < nums.length; i++) {
            if (b < 0) {
                b = nums[i];
            } else {
                b += nums[i];
            }
            if (b > sum) {
                sum = b;
            }
        }
        return sum;
    }
}

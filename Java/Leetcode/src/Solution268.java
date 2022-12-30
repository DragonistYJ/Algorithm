/**
 * @author 11214
 * @since 2022/12/30 14:52
 * <p>
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i + 1;
        }
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}

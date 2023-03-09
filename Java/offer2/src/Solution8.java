/**
 * @author 11214
 * @since 2023/3/9 10:55
 */
public class Solution8 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (true) {
            if (sum < target) {
                sum += nums[j];
                j += 1;
            } else {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i];
                i += 1;
            }

            if ((j == n || i == n) && sum < target) {
                break;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution8().minSubArrayLen(10, new int[]{1, 1, 1}));
    }
}

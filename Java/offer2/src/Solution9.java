/**
 * @author 11214
 * @since 2023/3/9 10:07
 */
public class Solution9 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 12));
    }
}

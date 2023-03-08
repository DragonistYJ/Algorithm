/**
 * @author 11214
 * @since 2023/3/7 20:05
 */
public class Solution4 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            int c = 0;
            int bit = 1 << i;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    c += 1;
                }
            }
            if (c % 3 != 0) {
                ans += bit;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().singleNumber(new int[]{-2, -2, -2, 4}));
    }
}

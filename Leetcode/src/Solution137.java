/*
NO137 只出现一次的数字2
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int mask = 1 << (31 - i);
            int sum = 0;
            for (int num : nums) {
                if ((mask & num) != 0) {
                    sum += 1;
                }
            }
            if (sum % 3 != 0) {
                ans = ans | mask;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1, 0, 1, -8};
        System.out.println(new Solution137().singleNumber(nums));
    }
}
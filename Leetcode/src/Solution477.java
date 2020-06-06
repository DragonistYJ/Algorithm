/**
 * @ClassName Solution477
 * @Author 11214
 * @Date 2020/6/5
 * @Description 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 */
public class Solution477 {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            int zero = 0;
            for (int j = 0; j < n; j++) {
                if ((nums[j] & 1) == 1) one += 1;
                else zero += 1;
                nums[j] = nums[j] >> 1;
            }
            ans += one * zero;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        System.out.println(new Solution477().totalHammingDistance(nums));
    }
}

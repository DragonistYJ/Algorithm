import java.util.Arrays;

/**
 * @author 11214
 * @since 2022/11/18 15:50
 * <p>
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 */
public class Solution561 {
    public int arrayPairSum(int[] nums) {
        int[] ints = Arrays.stream(nums).sorted().toArray();
        int ans = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            ans += Math.min(ints[i * 2], ints[i * 2 + 1]);
        }
        return ans;
    }
}

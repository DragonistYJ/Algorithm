package offer;

import java.util.Arrays;

/**
 * @author 11214
 * @since 2022/12/5 16:25
 * <p>
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 */
public class Solution3 {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }

        int[] ans = new int[n + 1];
        ans[1] = 1;
        int step = 2;
        int root = 2;
        while (step <= n) {
            ans[step] = ans[step - root] + 1;
            step += 1;
            if (step % root == 0) {
                root *= 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution3().countBits(10)));
    }
}

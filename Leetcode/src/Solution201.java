/**
 * @ClassName Solution201
 * @Author 11214
 * @Date 2020/6/5
 * @Description 数字范围安按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        int[] ans = new int[32];
        int[] bits = new int[32];
        int k = m;
        for (int i = 0; i < 32; i++) {
            bits[i] = k & 1;
            k = k>> 1;
        }
        int binary = 1;
        for (int i = 0; i < 32; i++) {
            int total = binary - m % binary;
            if ((n - m + 1) <= total && bits[i] == 1) ans[i] = 1;
            binary *= 2;
        }
        int ret = 0;
        for (int i = 31; i >= 0; i--) {
            ret = ret << 1;
            ret = ret | ans[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution201().rangeBitwiseAnd(0, 1));
    }
}

/*
NO878 第N个神奇数字
如果正整数可以被 A 或 B 整除，那么它是神奇的。
返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
 */
public class Solution878 {
    public int nthMagicalNumber(int N, int A, int B) {
        int lcm;
        if (A > B) lcm = gcd(A, B);
        else lcm = gcd(B, A);
        lcm = A / lcm * B;
        int nums = lcm / A + lcm / B - 1;
        int mod = 1000000000 + 7;
        int q = N / nums;
        int p = N % nums;
        long ans = (long) q * lcm % mod;
        if (p == 0) return (int) ans;

        int[] heads = new int[]{A, B};
        for (int i = 0; i < p - 1; ++i) {
            if (heads[0] <= heads[1])
                heads[0] += A;
            else
                heads[1] += B;
        }

        ans += Math.min(heads[0], heads[1]);
        return (int) (ans % mod);
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(new Solution878().nthMagicalNumber(5, 2, 4));
    }
}

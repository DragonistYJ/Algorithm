package interview;

import java.math.BigInteger;

/**
 * @ClassName Solution14_2
 * @Author 11214
 * @Date 2020/4/14
 * @Description TODO
 */
public class Solution14_2 {
    public int cuttingRope(int n) {
        if (n == 1 || n == 2) return 1;

        BigInteger[] dp = new BigInteger[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = BigInteger.ZERO;
        }
        BigInteger mod = new BigInteger("1000000007");
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                BigInteger temp = dp[j].max(BigInteger.valueOf(j)).multiply(dp[i - j].max(BigInteger.valueOf(i - j)));
                dp[i] = temp.max(dp[i]);
            }
        }

        return dp[n].mod(mod).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new Solution14_2().cuttingRope(127));
    }
}

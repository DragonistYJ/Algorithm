import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;

/**
 * @author 11214
 * @since 2023/3/1 10:04
 */
public class Solution971C {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        BigInteger[] nums = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            nums[i] = BigInteger.valueOf((long) st.nval);
        }

        BigInteger[][] dp = new BigInteger[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }
        BigInteger max = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            dp[i][(i + 2) % n] = nums[i].multiply(nums[(i + 1) % n]).multiply(nums[(i + 2) % n]);
            if (max.compareTo(dp[i][(i + 2) % n]) < 0) {
                max = dp[i][(i + 2) % n];
            }
        }
        max = max.multiply(BigInteger.valueOf(n));

        for (int l = 4; l <= n; l++) {
            for (int s = 0; s < n; s++) {
                int e = s + l - 1;
                int e_ = e % n;
                dp[s][e_] = max;
                // i == s + 1
                BigInteger x = nums[s].multiply(nums[(s + 1) % n]).multiply(nums[e_]);
                x = x.add(dp[(s + 1) % n][e_]);
                if (dp[s][e_].compareTo(x) > 0) {
                    dp[s][e_] = x;
                }
                // i == e
                x = nums[s].multiply(nums[(e - 1) % n]).multiply(nums[e_]);
                x = x.add(dp[s][(e - 1) % n]);
                if (dp[s][e_].compareTo(x) > 0) {
                    dp[s][e_] = x;
                }

                for (int i = s + 2; i < e; i++) { // [s,i-1] [i,e]
                    int i_ = i % n;
                    BigInteger a = nums[s].multiply(nums[(i - 1) % n]).multiply(nums[i_])
                            .add(nums[s].multiply(nums[e_]).multiply(nums[i_]));
                    BigInteger b = nums[(i - 1) % n].multiply(nums[s]).multiply(nums[e_])
                            .add(nums[(i - 1) % n].multiply(nums[i_]).multiply(nums[e_]));
                    if (a.compareTo(b) > 0) {
                        a = b;
                    }
                    a = a.add(dp[s][(i - 1) % n]).add(dp[i_][e_]);
                    if (dp[s][e_].compareTo(a) > 0) {
                        dp[s][e_] = a;
                    }
                }
            }
        }

        BigInteger ans = max;
        for (int i = 0; i < n; i++) {
            if (dp[i][(i + n - 1) % n].compareTo(ans) < 0) {
                ans = dp[i][(i + n - 1) % n];
            }
        }
        System.out.println(ans.toString());
    }
}

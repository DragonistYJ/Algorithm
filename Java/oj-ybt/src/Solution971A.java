import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/28 20:12
 */
public class Solution971A {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            nums[i] = (long) st.nval;
        }
        long[] sums = new long[n * 2];
        sums[0] = nums[0];
        for (int i = 1; i < n * 2; i++) {
            sums[i] = sums[i - 1] + nums[i % n];
        }

        long[][] maxDP = new long[n][n];
        long[][] minDP = new long[n][n];
        for (int l = 2; l <= n; l++) {
            for (int s = 0; s < n; s++) {
                int e = s + l - 1;
                int e_ = e % n;
                maxDP[s][e_] = Long.MIN_VALUE;
                minDP[s][e_] = Long.MAX_VALUE;
                long sum = sums[e] - (s == 0 ? 0 : sums[s - 1]);
                for (int m = s + 1; m <= e; m++) {
                    int m_ = m % n;
                    maxDP[s][e_] = Math.max(maxDP[s][e_], maxDP[s][m_ == 0 ? n - 1 : m_ - 1] + maxDP[m_][e_] + sum);
                    minDP[s][e_] = Math.min(minDP[s][e_], minDP[s][m_ == 0 ? n - 1 : m_ - 1] + minDP[m_][e_] + sum);
                }
            }
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, maxDP[i][(i + n - 1) % n]);
            min = Math.min(min, minDP[i][(i + n - 1) % n]);
        }
        System.out.println(max);
        System.out.println(min);
    }
}

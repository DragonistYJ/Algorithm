import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/3/1 9:50
 */
public class Solution971B {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        long[][] nums = new long[n][2];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            nums[i][0] = (long) st.nval;
        }
        for (int i = 0; i < n; i++) {
            nums[i][1] = nums[(i + 1) % n][0];
        }

        long[][] dp = new long[n][n];
        for (int len = 2; len <= n; len++) {
            for (int s = 0; s < n; s++) {
                int e = s + len - 1;
                int e_ = e % n;
                for (int i = s + 1; i <= e; i++) { // [s,i-1],[i,e]
                    int i_ = i % n;
                    long energy = nums[s][0] * nums[i_][0] * nums[e_][1];
                    dp[s][e_] = Math.max(dp[s][e_], dp[s][i_ == 0 ? n - 1 : i_ - 1] + dp[i_][e_] + energy);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][(i + n - 1) % n]);
        }
        System.out.println(ans);
    }
}

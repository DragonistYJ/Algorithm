import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/3 20:41
 */
public class Solution973A {
    private static int k;
    private static int b;
    private static final List<Integer> uppers = new ArrayList<>();
    private static int[][][] dp;

    /**
     * @param idx   当前枚举到第idx位
     * @param n     前面有n个位被用过了
     * @param limit 是否被前一步触发限制
     */
    private static int dfs(int idx, int n, boolean limit) {
        if (n == k) {
            return 1;
        }
        if (idx == uppers.size()) {
            return 0;
        }
        if (dp[idx][n][limit ? 1 : 0] != -1) {
            return dp[idx][n][limit ? 1 : 0];
        }

        int up = limit ? Math.min(uppers.get(idx), 1) : 1;
        int ans = 0;
        for (int i = 0; i <= up; i++) {
            ans += dfs(idx + 1, i == 0 ? n : n + 1, i == uppers.get(idx) && limit);
        }
        dp[idx][n][limit ? 1 : 0] = ans;
        return ans;
    }

    private static int solve(long x) {
        uppers.clear();
        while (x != 0) {
            uppers.add((int) (x % b));
            x = x / b;
        }
        Collections.reverse(uppers);
        dp = new int[uppers.size()][k + 1][2];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(0, 0, true);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        long lower = (long) st.nval;
        st.nextToken();
        long upper = (long) st.nval;
        st.nextToken();
        k = (int) st.nval;
        st.nextToken();
        b = (int) st.nval;
        int ans1 = solve(lower - 1);
        int ans2 = solve(upper);
        System.out.println(ans2 - ans1);
    }
}

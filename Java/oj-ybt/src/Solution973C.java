import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/3 22:12
 */
public class Solution973C {
    private static final List<Integer> uppers = new ArrayList<>();
    private static int[][][][] dp;

    private static int dfs(int idx, int k, int start, boolean limit) {
        if (idx == uppers.size()) {
            return 1;
        }
        if (start != -1 && dp[idx][k][start][limit ? 1 : 0] != -1) {
            return dp[idx][k][start][limit ? 1 : 0];
        }
        int upper = limit ? uppers.get(idx) : 9;
        int ans = 0;
        for (int i = 0; i <= upper; i++) {
            if (start == -1) {
                ans += dfs(idx + 1, i, i == 0 ? -1 : idx, limit && i == uppers.get(idx));
            } else if (Math.abs(k - i) >= 2) {
                ans += dfs(idx + 1, i, start, limit && i == uppers.get(idx));
            }
        }
        if (start != -1) {
            dp[idx][k][start][limit ? 1 : 0] = ans;
        }
        return ans;
    }

    private static int solve(int x) {
        uppers.clear();
        while (x != 0) {
            uppers.add(x % 10);
            x = x / 10;
        }
        Collections.reverse(uppers);
        dp = new int[uppers.size()][10][uppers.size()][2];
        for (int[][][] arr1 : dp) {
            for (int[][] arr2 : arr1) {
                for (int[] arr3 : arr2) {
                    Arrays.fill(arr3, -1);
                }
            }
        }
        return dfs(0, -2, -1, true);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int lower = (int) st.nval;
        st.nextToken();
        int upper = (int) st.nval;
        int ans1 = solve(lower - 1);
        int ans2 = solve(upper);
        System.out.println(ans2 - ans1);
    }
}

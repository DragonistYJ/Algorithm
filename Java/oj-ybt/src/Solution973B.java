import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/3 21:45
 */
public class Solution973B {
    private static final List<Integer> uppers = new ArrayList<>();
    private static int[][][] dp;

    private static int dfs(int idx, int k, boolean limit) {
        if (idx == uppers.size()) {
            return 1;
        }
        if (dp[idx][k][limit ? 1 : 0] != -1) {
            return dp[idx][k][limit ? 1 : 0];
        }
        int ans = 0;
        int upper = limit ? uppers.get(idx) : 9;
        for (int i = k; i <= upper; i++) {
            ans += dfs(idx + 1, i, limit && i == uppers.get(idx));
        }
        dp[idx][k][limit ? 1 : 0] = ans;
        return ans;
    }

    private static int solve(int x) {
        uppers.clear();
        while (x != 0) {
            uppers.add(x % 10);
            x = x / 10;
        }
        Collections.reverse(uppers);
        dp = new int[uppers.size()][10][2];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(0, 0, true);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        int lower;
        int upper;
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            lower = (int) st.nval;
            st.nextToken();
            upper = (int) st.nval;
            int ans1 = solve(lower - 1);
            int ans2 = solve(upper);
//            System.out.println(ans2 - ans1 + "\n");
            writer.write(ans2 - ans1 + "\n");
        }
        writer.flush();
        writer.close();
    }
}

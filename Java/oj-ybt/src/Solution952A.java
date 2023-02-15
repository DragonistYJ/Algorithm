import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/15 9:47
 */
public class Solution952A {
    public static int dfs(int remind, int low, int step) {
        if (step == 0) {
            return remind == 0 ? 1 : 0;
        }
        int ans = 0;
        for (int i = low; i <= remind; i++) {
            ans += dfs(remind - i, i, step - 1);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;
        int ans = dfs(n, 1, k);
        System.out.println(ans);
    }
}

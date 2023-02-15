import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/2/13 21:35
 */
public class Solution952E {
    private static int n;
    private static boolean[] nums;
    private static int[] sums;
    private static boolean flag = false;

    private static int[] ans;

    private static void dfs(int idx, int pre, int post, int preIdx, int postIdx) {
        if (flag) {
            return;
        }

        if (preIdx == postIdx) {
            int a = sums[n * 2 - 1] - pre - post;
            if (a >= 1 && a <= 500 && nums[a]) {
                ans[preIdx] = a;
                for (int i = 0; i < n; i++) {
                    System.out.print(ans[i]);
                    if (i != n - 1) {
                        System.out.print(" ");
                    }
                }
                flag = true;
            }
            return;
        }

        int a;
        a = sums[idx] - pre;
        if (a >= 1 && a <= 500 && nums[a]) {
            ans[preIdx] = a;
            dfs(idx + 1, pre + a, post, preIdx + 1, postIdx);
        }
        a = sums[idx] - post;
        if (a >= 1 && a <= 500 && nums[a]) {
            ans[postIdx] = a;
            dfs(idx + 1, pre, post + a, preIdx, postIdx - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        n = (int) st.nval;
        sums = new int[n * 2];
        ans = new int[n];
        for (int i = 0; i < n * 2; i++) {
            st.nextToken();
            int a = (int) st.nval;
            sums[i] = a;
        }
        Arrays.sort(sums);
        st.nextToken();
        int m = (int) st.nval;
        nums = new boolean[501];
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int a = (int) st.nval;
            nums[a] = true;
        }
        dfs(0, 0, 0, 0, n - 1);
    }
}

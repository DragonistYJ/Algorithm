import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/16 10:23
 */
public class Solution952D {
    private static final int[] memos = new int[101];
    private static final int[] ans = new int[101];

    private static void dfs(int t, int[] a, int n) {
        if (a[t - 1] == n) {
            System.arraycopy(a, 0, ans, 0, t);
        }

        for (int i = t - 1; i >= 0; i--) {
            for (int j = t - 1; j >= 0; j--) {
                int k = a[i] + a[j];
                if (k < a[t - 1]) {
                    break;
                }
                if (k > n) {
                    continue;
                }
                if (t <= memos[k]) {
                    memos[k] = t;
                    a[t] = k;
                    dfs(t + 1, a, n);
                    a[t] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        for (int i = 0; i <= 100; i++) {
            memos[i] = Integer.MAX_VALUE;
        }
        int n;
        do {
            st.nextToken();
            n = (int) st.nval;
            if (n == 1) {
                System.out.println("1");
            } else if (n == 2) {
                System.out.println("1 2");
            } else if (n > 2) {
                int[] a = new int[n];
                a[0] = 1;
                a[1] = 2;
                dfs(2, a, n);
                for (int i = 0; i <= memos[n]; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
        } while (n != 0);
    }
}

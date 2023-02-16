import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/2/16 11:22
 */
public class Solution952F {
    private static final int[] ans = new int[10000010];
    private static boolean flag = false;

    private static long gcd(long a, long b) {
        long c = -1;
        while (c != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private static int[] sub(int[] ab, int n) {
        long mu = (long) ab[1] * (long) n;
        long zi = (long) ab[0] * (long) n - (long) ab[1];
        long gcd = gcd(zi, mu);
        return new int[]{(int) (zi / gcd), (int) (mu / gcd)};
    }

    private static void dfs(int step, int pre, int[] ab, int[] trace, int maxStep) {
        // 还剩1步，直接判断
        if (step + 1 == maxStep) {
            if (ab[0] == 1 && (step == 0 || ab[1] != trace[step - 1]) && ab[1] < ans[step]) {
                trace[step] = ab[1];
                System.arraycopy(trace, 0, ans, 0, step + 1);
                trace[step] = 0;
                flag = true;
            }
            return;
        }

        int lower = Math.max(pre, ab[1] / ab[0] + 1);
        int upper = ab[1] * (maxStep - step) / ab[0];
        for (int i = lower; i <= upper; i++) {
            int[] reminder = sub(ab, i);
            if (reminder[0] < 0 || reminder[1] < 0) {
                continue;
            }
            trace[step] = i;
            dfs(step + 1, i + 1, reminder, trace, maxStep);
            trace[step] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int[] ab = new int[2];
        ab[0] = (int) st.nval;
        st.nextToken();
        ab[1] = (int) st.nval;
        long gcd = gcd(ab[0], ab[1]);
        ab[0] /= gcd;
        ab[1] /= gcd;
        Arrays.fill(ans, Integer.MAX_VALUE);

        int deep;
        for (deep = 1; deep <= 10000000; deep++) {
            dfs(0, 1, ab, new int[10000010], deep);
            if (flag) {
                break;
            }
        }

        for (int i = 0; i < deep; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

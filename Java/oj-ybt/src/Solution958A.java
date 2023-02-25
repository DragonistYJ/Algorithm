import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/24 21:50
 */
public class Solution958A {
    public static int lowBit(int i) {
        return i & (-i);
    }

    public static void add(long[] t, int i, long x) {
        while (i < t.length) {
            t[i] += x;
            i += lowBit(i);
        }
    }

    public static long rangeSum(long[] t, int l, int r) {
        long left = 0;
        l -= 1;
        while (l > 0) {
            left += t[l];
            l -= lowBit(l);
        }
        long right = 0;
        while (r > 0) {
            right += t[r];
            r -= lowBit(r);
        }

        return right - left;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int q = (int) st.nval;
        long[] nums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            st.nextToken();
            nums[i] = (long) st.nval;
        }
        long[] t = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i - lowBit(i) + 1; j <= i; j++) {
                t[i] += nums[j];
            }
        }

        for (int i = 0; i < q; i++) {
            st.nextToken();
            int type = (int) st.nval;
            st.nextToken();
            int a = (int) st.nval;
            st.nextToken();
            int b = (int) st.nval;
            if (type == 1) {
                add(t, a, b);
            } else {
                long sum = rangeSum(t, a, b);
                writer.write(String.valueOf(sum));
            }
        }
    }
}

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/3/6 10:36
 */
public class Solution975B {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        long[] nums = new long[n];
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            nums[i] = (long) st.nval;
            sums[i + 1] = sums[i] + nums[i];
        }

        int left = -1;
        int idx = 0;
        long max = Long.MIN_VALUE;
        while (idx < n) {
            if (sums[idx + 1] - sums[left + 1] < 0) {
                max = Math.max(max, sums[idx + 1] - sums[idx]);
                left = idx;
            } else {
                if (idx - left > m) {
                    left += 1;
                }
                max = Math.max(max, sums[idx + 1] - sums[left + 1]);
            }
            idx += 1;
        }
        System.out.println(max);
    }
}

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/3/4 11:22
 */
public class Solution977C {
    private static long fatPow(long k, long n) {
        if (k == 0) {
            return 1;
        }
        if (k == 1) {
            return 10 % n;
        }
        long ans = k % 2 == 1 ? 10 % n : 1;
        long res = fatPow(k / 2, n);
        ans = ((ans * res) % n * res) % n;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        long n = (long) st.nval;
        st.nextToken();
        long m = (long) st.nval;
        st.nextToken();
        long k = (long) st.nval;
        st.nextToken();
        long x = (long) st.nval;
        long ans = (x + m * fatPow(k, n)) % n;
        System.out.println(ans);
    }
}

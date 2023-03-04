import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/3/4 10:48
 */
public class Solution977A {
    private static final long MOD = 200907;

    private static long binary(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % MOD;
        }

        long ans = 1;
        if (b % 2 == 1) {
            ans = a;
        }
        long res = binary(a, b / 2) % MOD;
        ans = (ans * ((res * res) % MOD)) % MOD;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int t = (int) st.nval;
        while (t-- > 0) {
            st.nextToken();
            long a = (long) st.nval;
            st.nextToken();
            long b = (long) st.nval;
            st.nextToken();
            long c = (long) st.nval;
            st.nextToken();
            long k = (long) st.nval;
            long res;
            if (b - a == c - b) {
                long x = b - a;
                res = (x * (k - 1) + a) % MOD; //有减法不能拆分，会出现负数
            } else {
                long x = b / a;
                res = a * binary(x, k - 1) % MOD;
            }
            System.out.println(res);
        }
    }
}

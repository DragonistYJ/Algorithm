import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/3/4 10:38
 */
public class Solution977B {
    private static long binary(long a, long b, long m) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % m;
        }

        long ans = 1;
        if (b % 2 == 1) {
            ans = a;
        }
        long res = binary(a, b / 2, m) % m;
        ans = (ans * ((res * res) % m)) % m;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        long a = (long) st.nval;
        st.nextToken();
        long b = (long) st.nval;
        st.nextToken();
        long m = (long) st.nval;
        long res = binary(a, b, m);
        System.out.println(res);
    }
}

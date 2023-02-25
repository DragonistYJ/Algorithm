import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/2/25 9:50
 */
public class Solution958B {
    private static int lowBit(int i) {
        return i & (-i);
    }

    private static void add(int[] arr, int i, int x) {
        while (i < arr.length) {
            arr[i] += x;
            i += lowBit(i);
        }
    }

    private static int query(int[] arr, int r) {
        int ans = 0;
        while (r > 0) {
            ans += arr[r];
            r -= lowBit(r);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        int[] arr = new int[32000 + 10];
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            int x = (int) st.nval;
            x += 1;
            st.nextToken();
            int y = (int) st.nval;
            add(arr, x, 1);
            ans[query(arr, x)] += 1;
        }
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        for (int i = 1; i <= n; i++) {
            writer.write(ans[i] + "\n");
        }
        writer.flush();
        writer.close();
    }
}

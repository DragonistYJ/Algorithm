import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 11214
 * @since 2023/2/4 10:29
 */
public class Solution950C {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int t = (int) st.nval;
        while (t-- > 0) {
            st.nextToken();
            int n = (int) st.nval;
            st.nextToken();
            int l = (int) st.nval;
            st.nextToken();
            int w = (int) st.nval;
            double[][] ranges = new double[n][2];
            for (int i = 0; i < n; i++) {
                st.nextToken();
                int c = (int) st.nval;
                st.nextToken();
                int r = (int) st.nval;
                double x = Math.sqrt(r * r - (w / 2.0) * (w / 2.0));
                ranges[i][0] = Math.max(0, c - x);
                ranges[i][1] = Math.min(l, c + x);
            }
            Arrays.sort(ranges, Comparator.comparingDouble(o -> o[0]));

            int ans = 0;
            double current = 0;
            double maxRight = 0;
            boolean flag = true;
            int i = 0;
            while (i < n) {
                double[] range = ranges[i];
                if (range[0] <= current) {
                    maxRight = Math.max(maxRight, range[1]);
                    i += 1;
                } else {
                    if (range[0] > maxRight) {
                        flag = false;
                        break;
                    } else {
                        current = maxRight;
                        ans += 1;
                    }
                }
            }
            System.out.println(flag ? ans + 1 : -1);
        }
    }
}

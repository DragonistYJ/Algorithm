import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/2/5 15:38
 */
public class Solution951A {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            positions[i] = (int) st.nval;
        }

        if (m > n) {
            System.out.println(0);
            return;
        }

        Arrays.sort(positions);
        int left = 0;
        int right = (positions[n - 1] - positions[0]) / (m - 1);
        while (left + 1 < right) {
            int mid = (left + right) / 2;

            int k = 1;
            int min = positions[0];
            for (int i = 0; i < n; i++) {
                if (positions[i] - min >= mid) {
                    k += 1;
                    min = positions[i];
                }
            }

            if (k >= m) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }
}

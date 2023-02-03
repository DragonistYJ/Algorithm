import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/2/3 11:44
 */
public class Solution950A {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            ranges[i][0] = (int) st.nval;
            st.nextToken();
            ranges[i][1] = (int) st.nval;
        }
        Arrays.sort(ranges, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int ans = 0;
        int end = 0;
        for (int[] range : ranges) {
            if (range[0] >= end) {
                ans += 1;
                end = range[1];
            }
        }
        System.out.println(ans);
    }
}

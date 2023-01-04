import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author 11214
 * @since 2023/1/4 11:02
 * <p>
 * Scanner会超时
 */
public class Solution13591 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int[] scores = new int[100010];
        while (sc.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) sc.nval;
            sc.nextToken();
            int m = (int) sc.nval;
            for (int i = 0; i < n; i++) {
                sc.nextToken();
                scores[i] = (int) sc.nval;
            }
            Arrays.sort(scores, 0, n);
            int i = 0;
            int ans = 0;
            while (i < n - 1) {
                if ((scores[i + 1] - scores[i]) < m) {
                    ans += 1;
                    i += 2;
                } else {
                    i += 1;
                }
            }
            System.out.println(ans);
        }
    }
}

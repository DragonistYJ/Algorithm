import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/1/6 14:45
 */
public class Solution16600 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(System.in));
        tokenizer.nextToken();
        int n = (int) tokenizer.nval;
        tokenizer.nextToken();
        int m = (int) tokenizer.nval;
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            tokenizer.nextToken();
            weights[i] = (int) tokenizer.nval;
        }
        int t = 0;
        int[] taps = new int[m];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            taps[i] = weights[i];
            min = Math.min(min, taps[i]);
        }

        int idx = m;
        while (idx < n) {
            t += min;
            int tempMin = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                taps[i] -= min;
                if (taps[i] == 0 && idx < n) {
                    taps[i] = weights[idx];
                    idx += 1;
                }
                tempMin = Math.min(tempMin, taps[i]);
            }
            min = tempMin;
        }
        int reminder = 0;
        for (int tap : taps) {
            reminder = Math.max(reminder, tap);
        }
        t += reminder;
        System.out.println(t);
    }
}

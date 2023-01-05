import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/1/5 11:09
 */
public class Solution14517 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(System.in));
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            String s = tokenizer.sval;
            StringBuilder builder = new StringBuilder();
            builder.append("$#");
            for (int i = 0; i < s.length(); i++) {
                builder.append(s.charAt(i));
                builder.append("#");
            }
            builder.append("^");

            int[] p = new int[builder.length()];
            int center = 0;
            int right = 0;
            for (int i = 1; i < builder.length() - 1; i++) {
                int mirror = 2 * center - i;
                if (right > i) {
                    p[i] = Math.min(right - i, p[mirror]);
                } else {
                    p[i] = 1;
                }
                while (builder.charAt(i - p[i]) == builder.charAt(i + p[i])) {
                    p[i] += 1;
                }
                if (i + p[i] > right) {
                    right = i + p[i];
                    center = i;
                }
            }
            int max = 0;
            for (int i : p) {
                max = Math.max(i, max);
            }
            System.out.println(max - 1);
        }
    }
}

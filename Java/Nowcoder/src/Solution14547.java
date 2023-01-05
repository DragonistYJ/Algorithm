import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/1/5 11:43
 */
public class Solution14547 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(System.in));
        tokenizer.nextToken();
        int n = (int) tokenizer.nval;
        while (n-- > 0) {
            tokenizer.nextToken();
            String s = tokenizer.sval;
            long ans = 0;
            int l = 0;
            int o = 0;
            int v = 0;
            int e = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'L') {
                    l = i + 1;
                } else if (c == 'O') {
                    o = i + 1;
                } else if (c == 'V') {
                    v = i + 1;
                } else if (c == 'E') {
                    e = i + 1;
                }
                ans += Math.min(Math.min(l, o), Math.min(v, e));
            }
            System.out.println(ans);
        }
    }
}

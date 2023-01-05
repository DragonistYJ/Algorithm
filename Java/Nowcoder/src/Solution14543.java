import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/1/5 11:49
 */
public class Solution14543 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(System.in));
        tokenizer.nextToken();
        int n = (int) tokenizer.nval;
        while (n-- > 0) {
            tokenizer.nextToken();
            String s = tokenizer.sval;
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                ans += s.charAt(i) - 'A' + 1;
            }
            System.out.println(ans);
        }
    }
}

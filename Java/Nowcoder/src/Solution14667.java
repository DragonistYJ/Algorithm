import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @author 11214
 * @since 2023/1/4 11:44
 */
public class Solution14667 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer sc = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        sc.nextToken();
        int n = (int) sc.nval;
        while (n-- > 0) {
            sc.nextToken();
            int m = (int) sc.nval;
            int max = 0;
            for (int i = 0; i < m; i++) {
                sc.nextToken();
                int x = (int) sc.nval;
                sc.nextToken();
                int y = (int) sc.nval;
                sc.nextToken();
                int a = (int) sc.nval;
                sc.nextToken();
                int b = (int) sc.nval;
                max = Math.max(max, Math.abs(x - a) + Math.abs(y - b));
            }
            System.out.println(max);
        }
    }
}

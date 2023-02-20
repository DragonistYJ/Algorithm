import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/20 9:37
 */
public class Solution954D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] prefixHashes = new long[400010];
        long p = 31;
        long[] pl = new long[400010];
        pl[0] = 1;
        for (int i = 1; i < 400010; i++) {
            pl[i] = pl[i - 1] * p;
        }

        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            int len = string.length();

            prefixHashes[0] = string.charAt(0);
            for (int i = 1; i < len; i++) {
                prefixHashes[i] = prefixHashes[i - 1] * p + string.charAt(i);
            }

            for (int i = 1; i < len; i++) {
                long prefix = prefixHashes[i - 1];
                long suffix = prefixHashes[len - 1] - prefixHashes[len - i - 1] * pl[i];
                if (prefix == suffix) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(len);
        }
    }
}

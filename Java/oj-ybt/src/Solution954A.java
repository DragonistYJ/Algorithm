import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/19 11:05
 */
public class Solution954A {
    private static final long P = 31;

    public static int value(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 26;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int la = a.length();
        String b = sc.next();
        int lb = b.length();
        long bHash = 0;
        for (int i = 0; i < lb; i++) {
            bHash = bHash * P + value(b.charAt(i));
        }

        long pb = P;
        for (int i = 1; i < lb; i++) {
            pb = pb * P;
        }

        long[] aHashes = new long[la];
        aHashes[0] = value(a.charAt(0));
        for (int i = 1; i < la; i++) {
            aHashes[i] = aHashes[i - 1] * P + value(a.charAt(i));
        }

        int ans = 0;
        for (int i = 0; i <= la - lb; i++) {
            int j = i + lb - 1;
            long h = aHashes[j] - i == 0 ? 0 : aHashes[i - 1] * pb;
            if (h == bHash) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}

import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/19 12:25
 */
public class Solution954C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long p = 31;
        long[] segPs = new long[1000010];
        segPs[0] = 1;
        for (int i = 1; i < 1000000; i++) {
            segPs[i] = segPs[i - 1] * p;
        }
        String s;
        while (true) {
            s = sc.next();
            if (s.equals(".")) {
                break;
            }
            int l = s.length();
            long[] hashes = new long[l];
            hashes[0] = s.charAt(0);
            for (int i = 1; i < l; i++) {
                hashes[i] = hashes[i - 1] * p + s.charAt(i);
            }
            for (int seg = 1; seg <= l; seg++) {
                if (l % seg != 0) {
                    continue;
                }
                long hash = 0;
                for (int i = 0; i < seg; i++) {
                    hash = hash * p + s.charAt(i);
                }
                boolean flag = true;
                for (int i = seg; i <= l - seg; i += seg) {
                    int j = i + seg - 1;
                    long h = hashes[j] - hashes[i - 1] * segPs[seg];
                    if (h != hash) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(l / seg);
                    break;
                }
            }
        }
    }
}

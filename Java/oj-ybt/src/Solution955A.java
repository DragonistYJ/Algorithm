import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/21 9:45
 */
public class Solution955A {
    /**
     * 字符串哈希做法
     */
    public static void stringHash() {
        long p = 31;
        long[] pw = new long[1010];
        pw[0] = 1;
        for (int i = 1; i < 1010; i++) {
            pw[i] = pw[i - 1] * p;
        }
        long[] sHash = new long[1010];

        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            int ls = s.length();
            if (s.equals("#")) {
                break;
            }
            sHash[0] = s.charAt(0);
            for (int i = 1; i < ls; i++) {
                sHash[i] = sHash[i - 1] * p + s.charAt(i);
            }

            String pattern = sc.next();
            int lp = pattern.length();
            long patternHash = 0;
            for (int i = 0; i < lp; i++) {
                patternHash = patternHash * p + pattern.charAt(i);
            }

            int ans = 0;
            int i = 0;
            while (i + lp <= ls) {
                int j = i + lp - 1;
                long h = sHash[j] - (i == 0 ? 0 : sHash[i - 1]) * pw[lp];
                if (h == patternHash) {
                    ans += 1;
                    i += lp;
                } else {
                    i += 1;
                }
            }
            System.out.println(ans);
        }
    }

    /**
     * KMP做法
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            int ls = s.length();
            if (s.equals("#")) {
                break;
            }
            String pattern = sc.next();
            int lp = pattern.length();

            // 求next数组
            int[] next = new int[lp];
            int i = 1;
            int prefix_len = 0;
            while (i < lp) {
                if (pattern.charAt(i) == pattern.charAt(prefix_len)) {
                    prefix_len += 1;
                    next[i] = prefix_len;
                    i += 1;
                } else {
                    if (prefix_len == 0) {
                        i += 1;
                    } else {
                        prefix_len = next[prefix_len - 1];
                    }
                }
            }

            // 比对
            int ans = 0;
            i = 0;
            int j = 0;
            while (j < ls) {
                if (pattern.charAt(i) == s.charAt(j)) {
                    i += 1;
                    j += 1;
                } else if (i > 0) {
                    i = next[i - 1];
                } else {
                    j += 1;
                }

                if (i == lp) {
                    ans += 1;
                    i = 0;
                }
            }
            System.out.println(ans);
        }
    }
}

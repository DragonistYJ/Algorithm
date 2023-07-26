/**
 * @author yujian
 * @since 2023/7/23 11:28
 */
public class Solution214 {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }

        int n = s.length();
        int b = 1331;
        long[] p = new long[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] * b;
        }

        long[] positives = new long[n];
        long[] reverses = new long[n];
        long hash = 0;
        for (int i = 0; i < n; i++) {
            hash = hash * b + s.charAt(i);
            positives[i] = hash;
        }
        hash = 0;
        for (int i = 0; i < n; i++) {
            hash = hash * b + s.charAt(n - i - 1);
            reverses[i] = hash;
        }

        if (positives[n - 1] == reverses[n - 1]) {
            return s;
        }
        for (int i = n - 2; i >= 0; i--) {
            long positive = positives[i];
            long reverse = reverses[n - 1] - reverses[n - (i + 1) - 1] * p[i + 1];
            if (positive == reverse) {
                StringBuilder sb = new StringBuilder();
                for (int j = n - 1; j > i; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(s);
                return sb.toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution214 solution = new Solution214();
        System.out.println(solution.shortestPalindrome("a"));
    }
}

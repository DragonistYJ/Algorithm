/**
 * @author 11214
 * @since 2023/3/10 10:24
 */
public class Solution20 {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean[][] flags = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            flags[i][i] = true;
            ans += 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                flags[i][i + 1] = true;
                ans += 1;
            }
        }
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && flags[i + 1][j - 1]) {
                    flags[i][j] = true;
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution20().countSubstrings("aaa"));
    }
}

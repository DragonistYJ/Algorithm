/**
 * @ClassName Solution647
 * @Author 11214
 * @Date 2020/4/22
 * @Description TODO
 */
public class Solution647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) dp[i][i + 1] = true;
        }
        for (int i = 2; i < n; i++) {
            for (int l = 0; l < n - i; l++) {
                int r = l + i;
                if (s.charAt(l) == s.charAt(r) && dp[l + 1][r - 1]) dp[l][r] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution647().countSubstrings("abcba"));
    }
}

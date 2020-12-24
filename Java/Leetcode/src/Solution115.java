import java.util.Arrays;

/*
NO115 不同的子序列
给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        int n = t.length();
        int m = s.length();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new Solution115().numDistinct("babgbag", "bag"));
    }
}

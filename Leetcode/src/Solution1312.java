/*
NO1312 让字符串成为回文串的最小插入次数
给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
请你返回让 s 成为回文串的 最少操作次数 。
「回文串」是正读和反读都相同的字符串。
 */
public class Solution1312 {
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < len + 1; j++) {
                if (s.charAt(i - 1) == s.charAt(len - j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return len - dp[len][len];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1312().minInsertions("zzazz"));
    }
}

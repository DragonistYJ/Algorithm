/*
NO1143 最长公共子序列
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
若这两个字符串没有公共子序列，则返回 0。
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] ans = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    ans[i + 1][j + 1] = ans[i][j] + 1;
                } else {
                    ans[i + 1][j + 1] = Math.max(ans[i][j + 1], ans[i + 1][j]);
                }
            }
        }
        return ans[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1143().longestCommonSubsequence("abcde", "ace"));
    }
}

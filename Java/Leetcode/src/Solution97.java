/*
NO97 交错字符串
给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 */
public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 + l2 != s3.length()) return false;
        boolean[][] flags = new boolean[l1 + 1][l2 + 1];
        flags[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            if (s3.startsWith(s1.substring(0, i))) flags[i][0] = true;
        }
        for (int i = 1; i <= l2; i++) {
            if (s3.startsWith(s2.substring(0, i))) flags[0][i] = true;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (flags[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || flags[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    flags[i][j] = true;
                }
            }
        }
        return flags[l1][l2];
    }

    public static void main(String[] args) {

    }
}

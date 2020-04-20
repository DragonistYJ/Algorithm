import java.util.List;

/*
NO712 两个字符串的最小ASCII删除和
给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 */
public class Solution712 {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] maxSameLen = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    maxSameLen[i][j] = Math.max(maxSameLen[i - 1][j - 1] + s1.charAt(i - 1), Math.max(maxSameLen[i - 1][j], maxSameLen[i][j - 1]));
                } else {
                    maxSameLen[i][j] = Math.max(maxSameLen[i - 1][j], maxSameLen[i][j - 1]);
                }
            }
        }
        int sum1 = 0;
        for (int i = 0; i < len1; i++) {
            sum1 += s1.charAt(i);
        }
        int sum2 = 0;
        for (int i = 0; i < len2; i++) {
            sum2 += s2.charAt(i);
        }
        return sum1 + sum2 - maxSameLen[len1][len2] * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution712().minimumDeleteSum("delete", "leet"));
    }
}

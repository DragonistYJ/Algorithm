/*
NOP1278 分割回文串3
给你一个由小写字母组成的字符串 s，和一个整数 k。
请你按下面的要求分割字符串：
首先，你可以将 s 中的部分字符修改为其他的小写英文字母。
接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。
请返回以这种方式分割字符串所需修改的最少字符数。
 */
public class Solution1278 {
    public int palindromePartition(String s, int k) {
        int len = s.length();
        if (k == len) return 0;

        int[][] diffs = new int[len][len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int left = i;
                int right = j;
                int sum = 0;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) sum += 1;
                    left += 1;
                    right -= 1;
                }
                diffs[i][j] = sum;
            }
        }

        int[][] dp = new int[len][k + 1];
        for (int i = 1; i < len; i++) {
            int range = Math.min(k, i + 1);
            dp[i][1] = diffs[0][i];
            for (int j = 2; j <= range; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + diffs[l + 1][i]);
                }
            }
        }
        return dp[len - 1][k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1278().palindromePartition("aabbc", 4));
    }
}

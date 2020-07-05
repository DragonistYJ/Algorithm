#include <string>

using namespace std;

/**
 * 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 */
class Solution516 {
public:
    int longestPalindromeSubseq(string s) {
        int n = s.size();
        int dp[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) dp[i][j] = 0;
        }

        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1]) dp[i][i + 1] = 2;
            else dp[i][i + 1] = 1;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];
    }
};
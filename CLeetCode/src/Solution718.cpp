using namespace std;

#include <vector>
#include <algorithm>

class Solution718 {
public:
    int findLength(vector<int> &A, vector<int> &B) {
        int n = A.size();
        int m = B.size();
        int dp[n + 1][m + 1];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]) + 1;
                } else {
                    dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
                }
                ans = max(ans, dp[i + 1][j + 1]);
            }
        }

        return ans;
    }
};


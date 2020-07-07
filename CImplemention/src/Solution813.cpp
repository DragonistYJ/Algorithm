#include <vector>

using namespace std;

/**
 * 最大平均值和分组
 * 我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 * 注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
 */
class Solution {
public:
    double largestSumOfAverages(vector<int> &A, int K) {
        int n = A.size();
        vector<int> sums(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + A[i];
        }

        double dp[K + 1][n];
        for (int i = 1; i <= n; i++) {
            dp[1][i - 1] = sums[i] * 1.0 / i;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = i - 1; j < n; j++) {
                double maximum = 0;
                for (int k = i - 2; k < j; k++) {
                    maximum = max(maximum, dp[i - 1][k] + (sums[j + 1] - sums[k + 1]) * 1.0 / (j - k));
                }
                dp[i][j] = maximum;
            }
        }

        return dp[K][n - 1];
    }
};
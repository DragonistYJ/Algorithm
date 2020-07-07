#include <vector>

using namespace std;

/**
 * 统计全1字矩形
 * 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 */
class Solution {
public:
    int numSubmat(vector<vector<int>> &mat) {
        int n = mat.size();
        int m = mat[0].size();

        int left[n][m];
        for (int i = 0; i < n; i++) {
            int one = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) one += 1;
                else one = 0;
                left[i][j] = one;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minimum = 1000000;
                for (int k = i; k >= 0; k--) {
                    minimum = min(minimum, left[k][j]);
                    sum += minimum;
                }
            }
        }

        return sum;
    }
};
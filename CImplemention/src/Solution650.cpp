#include <vector>

using namespace std;

/**
 * 只有两个键的键盘
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 */
class Solution {
public:
    int minSteps(int n) {
        vector<int> vec(n + 1, n * 2);
        vec[1] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    vec[i] = min(vec[i], vec[j] + i / j);
                }
            }
        }

        return vec[n];
    }
};
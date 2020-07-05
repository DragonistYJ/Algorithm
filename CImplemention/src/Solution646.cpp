#include <vector>
#include <unordered_map>

using namespace std;

/**
 * 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 */
class Solution {
public:
    int n;

    int dfs(int index, bool used[], vector<vector<int>> &pairs, unordered_map<int, int> &memory) {
        auto ite = memory.find(index);
        if (ite != memory.end()) return ite->second;

        int len = 1;
        for (int i = 0; i < n; i++) {
            if (!used[i] && pairs[index][1] < pairs[i][0]) {
                used[i] = true;
                len = max(dfs(i, used, pairs, memory) + 1, len);
                used[i] = false;
            }
        }
        memory[index] = len;
        return len;
    }

    int findLongestChain(vector<vector<int>> &pairs) {
        n = pairs.size();
        bool used[n];
        for (int i = 0; i < n; i++) used[i] = false;
        unordered_map<int, int> memory;

        for (int i = 0; i < n; i++) {
            if (memory.find(i) == memory.end()) {
                dfs(i, used, pairs, memory);
            }
        }

        int ans = 1;
        for (auto &ite : memory) ans = max(ans, ite.second);

        return ans;
    }
};
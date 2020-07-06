#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

/**
 * 丑数2
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 */
class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> vec;
        vec.push_back(1);
        unordered_set<int> set;
        set.insert(1);
        vector<int> index(3, 0);

        while (vec.size() != n) {
            int i = 0;
            int min = 2 * vec[index[0]];
            if (3 * vec[index[1]] < min) {
                min = 3 * vec[index[1]];
                i = 1;
            }
            if (5 * vec[index[2]] < min) {
                min = 5 * vec[index[2]];
                i = 2;
            }

            if (set.find(min) == set.end()) {
                vec.push_back(min);
                set.insert(min);
            }
            index[i] += 1;
        }

        return vec[n - 1];
    }
};
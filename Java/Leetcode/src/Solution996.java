import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
NO996 正方形数组的数目
给定一个非负整数数组 A，如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为正方形数组。
返回 A 的正方形排列的数目。两个排列 A1 和 A2 不同的充要条件是存在某个索引 i，使得 A1[i] != A2[i]。
 */
public class Solution996 {
    int ans = 0;

    public int numSquarefulPerms(int[] A) {
        HashSet<Integer> squares = new HashSet<>();
        for (int i = 0; i < 46340; i++) {
            squares.add(i * i);
        }
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = 0;
        for (int value : A) {
            if (indexMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                indexMap.put(value, n);
                countMap.put(value, 1);
                n += 1;
            }
        }
        int[][] graph = new int[n][n];
        Set<Integer> set = indexMap.keySet();
        for (int value1 : set) {
            if (squares.contains(value1 + value1) && countMap.get(value1) > 1) {
                graph[indexMap.get(value1)][indexMap.get(value1)] = 1;
            }
            for (int value2 : set) {
                if (value1 == value2) continue;
                if (squares.contains(value1 + value2)) {
                    graph[indexMap.get(value1)][indexMap.get(value2)] = 1;
                    graph[indexMap.get(value2)][indexMap.get(value1)] = 1;
                }
            }
        }
        int[] count = new int[n];
        for (int value : set) {
            count[indexMap.get(value)] = countMap.get(value);
        }

        for (int i = 0; i < n; i++) {
            count[i] -= 1;
            dfs(graph, count, i, count[i] == 0 ? 1 : 0, n);
            count[i] += 1;
        }

        return ans;
    }

    private void dfs(int[][] graph, int[] count, int from, int m, int M) {
        if (m == M) {
            ans += 1;
            return;
        }
        for (int i = 0; i < M; i++) {
            if (count[i] != 0 && graph[from][i] == 1) {
                count[i] -= 1;
                dfs(graph, count, i, count[i] == 0 ? m + 1 : m, M);
                count[i] += 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {2, 2, 2};
        System.out.println(new Solution996().numSquarefulPerms(x));
    }
}

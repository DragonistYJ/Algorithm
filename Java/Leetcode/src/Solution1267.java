import java.util.HashMap;

/**
 * @author 11214
 * @since 2022/11/30 10:15
 * <p>
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 */
public class Solution1267 {
    private static class UnionSet {
        public HashMap<Integer, Integer> map = new HashMap<>();

        public int find(int x) {
            if (!map.containsKey(x)) {
                map.put(x, x);
            }
            if (x != map.get(x)) {
                map.put(x, find(map.get(x)));
            }
            return map.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            map.put(rootX, rootY);
        }
    }

    public int countServers(int[][] grid) {
        UnionSet unionSet = new UnionSet();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    unionSet.union(i + 251, j);
                }
            }
        }
        HashMap<Integer, Integer> setCount = new HashMap<>();
        for (int[] ints : grid) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 1) {
                    int root = unionSet.find(j);
                    setCount.put(root, setCount.getOrDefault(root, 0) + 1);
                }
            }
        }
        int ans = 0;
        for (Integer value : setCount.values()) {
            if (value != 1) {
                ans += value;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0}, {1, 1}};
        System.out.println(new Solution1267().countServers(grid));
    }
}

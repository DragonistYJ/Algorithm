import java.util.HashMap;

/**
 * @author 11214
 * @since 2022/11/30 10:38
 * <p>
 * 在由 1 x 1 方格组成的 n x n 网格 grid 中，每个 1 x 1 方块由 '/'、'\' 或空格构成。这些字符会将方块划分为一些共边的区域。
 * 给定网格 grid 表示为一个字符串数组，返回 区域的数量 。
 * 请注意，反斜杠字符是转义的，因此 '\' 用 '\\' 表示。
 */
public class Solution959 {
    private static class UnionSet {
        public HashMap<Integer, Integer> map = new HashMap<>();
        public int count = 0;

        public UnionSet() {
        }

        public int find(int x) {
            if (!map.containsKey(x)) {
                map.put(x, x);
                count += 1;
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
            count -= 1;
        }
    }

    public int regionsBySlashes(String[] grid) {
        UnionSet unionSet = new UnionSet();
        for (int i = 0; i < grid.length * grid.length * 4; i++) {
            unionSet.find(i);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                int base = (i * grid.length + j) * 4;
                if (grid[i].charAt(j) == ' ') {
                    unionSet.union(base, base + 1);
                    unionSet.union(base + 1, base + 2);
                    unionSet.union(base + 2, base + 3);
                }
                if (grid[i].charAt(j) == '/') {
                    unionSet.union(base, base + 3);
                    unionSet.union(base + 1, base + 2);
                }
                if (grid[i].charAt(j) == '\\') {
                    unionSet.union(base, base + 1);
                    unionSet.union(base + 2, base + 3);
                }
                if (i > 0) {
                    unionSet.union(base, base - grid.length * 4 + 2);
                }
                if (j > 0) {
                    unionSet.union(base + 3, base - 3);
                }
                if (i < grid.length - 1) {
                    unionSet.union(base + 2, base + grid.length * 4);
                }
                if (j < grid.length - 1) {
                    unionSet.union(base + 1, base + 7);
                }
            }
        }
        return unionSet.count;
    }

    public static void main(String[] args) {
        String[] grid = new String[]{" /", "/ "};
        System.out.println(new Solution959().regionsBySlashes(grid));
    }
}

import java.util.*;

/**
 * @author 11214
 * @since 2022/11/29 10:04
 * <p>
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 */
public class Solution947 {
    private static class UnionFind {
        public HashMap<Integer, Integer> parent = new HashMap<>();
        public int count = 0;

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count += 1;
            }
            if (x == parent.get(x)) {
                return x;
            } else {
                int root = find(parent.get(x));
                parent.put(x, root);
                return root;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent.put(rootX, rootY);
            count -= 1;
        }
    }

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.count;
    }

    public static void main(String[] args) {
        int[][] stones = new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        System.out.println(new Solution947().removeStones(stones));
    }
}

import java.util.HashMap;

/**
 * @author 11214
 * @since 2022/11/29 11:24
 * <p>
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。
 * 请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 */
public class Solution1319 {
    private static class UnionSet {
        public HashMap<Integer, Integer> parent = new HashMap<>();
        public int count = 0;

        public int find(int x) {
            // 第一次出现，新建一个组
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count += 1;
            }
            // 不是根节点，找到根节点，压缩路径
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            // 如果不在同一个集合，组合二者
            parent.put(rootX, rootY);
            count -= 1;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionSet unionSet = new UnionSet();
        for (int i = 0; i < n; i++) {
            unionSet.find(i);
        }
        for (int[] connection : connections) {
            unionSet.union(connection[0], connection[1]);
        }
        return unionSet.count - 1;
    }
}

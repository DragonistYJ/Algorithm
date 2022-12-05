import java.util.*;

/**
 * @author 11214
 * @since 2022/12/5 19:06
 * <p>
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 */
public class SolutionLCP7 {
    public int numWays(int n, int[][] relation, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] rel : relation) {
            if (!map.containsKey(rel[0])) {
                map.put(rel[0], new ArrayList<>());
            }
            map.get(rel[0]).add(rel[1]);
        }

        Queue<List<Integer>> paths = new ArrayDeque<>();
        List<Integer> path1 = new ArrayList<>();
        path1.add(0);
        paths.offer(path1);
        int ans = 0;
        while (!paths.isEmpty()) {
            List<Integer> path = paths.poll();
            if (path.size() == k + 1) {
                if (path.get(k) == n - 1) {
                    ans += 1;
                }
                continue;
            }
            Integer last = path.get(path.size() - 1);
            if (!map.containsKey(last)) {
                continue;
            }
            for (Integer node : map.get(last)) {
                ArrayList<Integer> p = new ArrayList<>(path);
                p.add(node);
                paths.offer(p);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] relations = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        System.out.println(new SolutionLCP7().numWays(5, relations, 3));
    }
}

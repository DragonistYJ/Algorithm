import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 11214
 * @since 2022/12/2 11:20
 * <p>
 * 给你两个整数数组 source 和 target ，长度都是 n 。
 * 还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。
 * 注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
 * 相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
 * 在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
 */
public class Solution1722 {
    private static class UnionSet {
        public HashMap<Integer, Integer> map = new HashMap<>();
        public int count;

        public Integer find(Integer x) {
            if (!map.containsKey(x)) {
                map.put(x, x);
                count += 1;
            }
            if (!x.equals(map.get(x))) {
                map.put(x, find(map.get(x)));
            }
            return map.get(x);
        }

        public void union(Integer x, Integer y) {
            Integer rootX = find(x);
            Integer rootY = find(y);
            if (rootX.equals(rootY)) {
                return;
            }
            map.put(rootX, rootY);
            count -= 1;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        UnionSet unionSet = new UnionSet();
        for (int i = 0; i < source.length; i++) {
            unionSet.find(i);
        }
        for (int[] allowedSwap : allowedSwaps) {
            unionSet.union(allowedSwap[0], allowedSwap[1]);
        }
        HashMap<Integer, Set<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            Integer root = unionSet.find(i);
            if (!groupMap.containsKey(root)) {
                groupMap.put(root, new HashSet<>());
            }
            groupMap.get(root).add(i);
        }
        int ans = 0;
        for (Set<Integer> indexes : groupMap.values()) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (Integer index : indexes) {
                map.put(source[index], map.getOrDefault(source[index], 0) + 1);
            }
            for (Integer index : indexes) {
                if (map.containsKey(target[index])) {
                    map.put(target[index], map.get(target[index]) - 1);
                    if (map.get(target[index]) == 0) {
                        map.remove(target[index]);
                    }
                }
            }
            ans += map.values().stream().reduce(Integer::sum).orElse(0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] source = new int[]{5, 1, 2, 4, 3};
        int[] target = new int[]{1, 5, 4, 2, 3};
        int[][] allowedSwaps = new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}};
        System.out.println(new Solution1722().minimumHammingDistance(source, target, allowedSwaps));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 组合总数3
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 */
public class Solution216 {
    private List<List<Integer>> dfs(List<Integer> path, int sum, int k, int n, int low) {
        if (k == 0) {
            List<List<Integer>> list = new ArrayList<>();
            if (sum == n) {
                list.add(new ArrayList<>(path));
            }
            return list;
        }
        if (sum >= n) return new ArrayList<>();


        List<List<Integer>> list = new ArrayList<>();
        for (int i = low; i < 10; i++) {
            if (sum + i <= n) {
                path.add(i);
                list.addAll(dfs(path, sum + i, k - 1, n, i + 1));
                path.remove(path.size() - 1);
            }
        }
        return list;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        return dfs(list, 0, k, n, 1);
    }

    public static void main(String[] args) {
        new Solution216().combinationSum3(3, 9).forEach(System.out::println);
    }
}

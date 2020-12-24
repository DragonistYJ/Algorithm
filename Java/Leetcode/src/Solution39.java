import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/*
NO39 组合总数
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> cache = new HashSet<>();
        dfs(cache, new ArrayList<>(), candidates, 0, target);
        return new ArrayList<>(cache);
    }

    private void dfs(HashSet<List<Integer>> cache, List<Integer> path, int[] candidates, int sum, int target) {
        if (sum == target) {
            List<Integer> tmp = new ArrayList<>(path);
            tmp.sort(Comparator.comparingInt(o -> o));
            cache.add(tmp);
            return;
        }
        for (int candidate : candidates) {
            if (sum + candidate <= target) {
                path.add(candidate);
                dfs(cache, path, candidates, sum + candidate, target);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {2, 3, 5};
        System.out.println(new Solution39().combinationSum(x, 8));
    }
}

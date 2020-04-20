import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
NO40 组合总数
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(new ArrayList<>());
        for (int candidate : candidates) {
            if (candidate > target) break;
            for (int i = target - candidate; i >= 0; i--) {
                List<List<Integer>> lists = dp.get(i);
                for (List<Integer> list : lists) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(candidate);
                    dp.get(i + candidate).add(tmp);
                }
            }
        }
        HashSet<List<Integer>> hashSet = new HashSet<>(dp.get(target));
        return new ArrayList<>(hashSet);
    }

    public static void main(String[] args) {
        int[] x = {2, 5, 2, 1, 1};
        List<List<Integer>> lists = new Solution40().combinationSum2(x, 5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}

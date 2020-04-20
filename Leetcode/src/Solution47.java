import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/*
NO47 全排列2
给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used = new int[nums.length];
        HashSet<List<Integer>> cache = new HashSet<>();
        dfs(cache, new ArrayList<>(), used, nums, 0, nums.length);
        return new ArrayList<>(cache);
    }

    private void dfs(HashSet<List<Integer>> cache, List<Integer> list, int[] used, int[] nums, int m, int M) {
        if (m == M) {
            cache.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) {
                list.add(nums[i]);
                used[i] = 1;
                dfs(cache, list, used, nums, m + 1, M);
                used[i] = 0;
                list.remove(m);
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {1, 1, 2};
        System.out.println(new Solution47().permuteUnique(x));
    }
}

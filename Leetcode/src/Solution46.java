import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
NO46 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), used, nums, 0, nums.length);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int[] used, int[] nums, int m, int M) {
        if (m == M) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) {
                list.add(nums[i]);
                used[i] = 1;
                dfs(ans, list, used, nums, m + 1, M);
                used[i] = 0;
                list.remove(m);
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4};
        System.out.println(new Solution46().permute(x));
    }
}

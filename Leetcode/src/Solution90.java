import java.util.*;

/**
 * @Author: YuJian
 * @Datetime: 2020/8/15 11:58
 * @Description 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class Solution90 {
    private void dfs(
            List<List<Integer>> ans, List<Integer> path,
            HashMap<Integer, Integer> countNum, List<Integer> nums, int index) {
        ans.add(new ArrayList<>(path));
        for (int i = index; i < nums.size(); i++) {
            int num = nums.get(i);
            int quantity = countNum.get(num);
            if (quantity > 0) {
                countNum.put(num, quantity - 1);
                path.add(num);
                dfs(ans, path, countNum, nums, i);
                path.remove(path.size() - 1);
                countNum.put(num, quantity);
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> countNum = new HashMap<>();
        for (int num : nums) {
            countNum.put(num, countNum.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(o -> o));

        dfs(ans, new ArrayList<>(), countNum, list, 0);
        return ans;
    }
}

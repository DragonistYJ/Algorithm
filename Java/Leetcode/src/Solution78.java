import java.util.ArrayList;
import java.util.List;

/*
NO78 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
 */
public class Solution78 {
    private List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        search(new ArrayList<>(), nums, 0);
        return ans;
    }

    private void search(List<Integer> tmp, int[] nums, int index) {
        ans.add(new ArrayList<>(tmp));

        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            search(tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution78().subsets(nums));
    }
}

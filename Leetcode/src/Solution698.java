import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution698
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution698 {
    private boolean dfs(int[] nums, int[] groups, int index) {
        if (index == nums.length) return true;
        int num = nums[index];
        for (int j = 0; j < groups.length; j++) {
            if (groups[j] - num >= 0) {
                groups[j] -= num;
                if (dfs(nums, groups, index + 1)) return true;
                groups[j] += num;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        if (k == 1) return true;
        int target = sum / k;
        int[] groups = new int[k];
        Arrays.fill(groups, target);
        return dfs(nums, groups, 0);
    }

    public static void main(String[] args) {
        int[] nums = {10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6};
        System.out.println(new Solution698().canPartitionKSubsets(nums, 3));
    }
}

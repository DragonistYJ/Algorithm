import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/9 10:41
 */
public class Solution7 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int idx = 0; idx < n; idx++) {
            int i = idx + 1;
            int j = n - 1;
            int target = -nums[idx];
            while (i < j) {
                int k = nums[i] + nums[j];
                if (k == target) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[idx], nums[i], nums[j]));
                    ans.add(list);
                    while (i + 1 < n && nums[i + 1] == nums[i]) {
                        i += 1;
                    }
                    while (j - 1 >= 0 && nums[j - 1] == nums[j]) {
                        j -= 1;
                    }
                    i += 1;
                    j -= 1;
                } else if (k < target) {
                    i += 1;
                } else {
                    j -= 1;
                }
            }
            while (idx + 1 < n && nums[idx + 1] == nums[idx]) {
                idx += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution7().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}

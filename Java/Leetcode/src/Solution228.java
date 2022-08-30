import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2022/8/30 10:51
 * 给定一个 无重复元素 的有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1] != 1)) {
                if (nums[i - 1] == start) {
                    ans.add(String.valueOf(start));
                } else {
                    ans.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }
        if (nums[nums.length - 1] == start) {
            ans.add(String.valueOf(start));
        } else {
            ans.add(start + "->" + nums[nums.length - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution228 solution228 = new Solution228();
        System.out.println(solution228.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}

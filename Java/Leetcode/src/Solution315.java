import java.util.ArrayList;
import java.util.List;

/*
NO315 计算右侧小于当前元素的个数
给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 */
public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return ans;
        for (int i = 0; i < len - 1; i++) {
            int x = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) x += 1;
            }
            ans.add(x);
        }
        ans.add(0);
        return ans;
    }

    public static void main(String[] args) {

    }
}

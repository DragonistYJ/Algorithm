import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2022/8/28 11:21
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。
 * 仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 */
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        numList.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (numList.get(numList.size() - 1) != nums[i]) {
                numList.add(nums[i]);
            }
        }

        if (numList.size() == 1) {
            return 1;
        }

        List<Integer> diff = new ArrayList<>();
        for (int i = 1; i < numList.size(); i++) {
            diff.add(numList.get(i) - numList.get(i - 1));
        }

        int symbol = diff.get(0) > 0 ? 1 : -1;
        int ans = 1;
        for (int i = 1; i < diff.size(); i++) {
            if (symbol * diff.get(i) < 0) {
                ans += 1;
                symbol *= -1;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        Solution376 solution376 = new Solution376();
        System.out.println(solution376.wiggleMaxLength(new int[]{1}));
    }
}

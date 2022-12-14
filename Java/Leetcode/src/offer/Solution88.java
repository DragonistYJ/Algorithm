package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2022/12/14 11:36
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */
public class Solution88 {
    public int minCostClimbingStairs(int[] cost) {
        List<Integer> ans = new ArrayList<>(cost.length);
        ans.add(cost[0]);
        ans.add(cost[1]);
        for (int i = 2; i < cost.length; i++) {
            ans.add(cost[i] + Math.min(ans.get(i - 1), ans.get(i - 2)));
        }
        return Math.min(ans.get(ans.size() - 1), ans.get(ans.size() - 2));
    }
}

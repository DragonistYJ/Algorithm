/*
NO746 使用最小花费爬楼梯
数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] ans = new int[len + 1];
        for (int i = 2; i < len + 1; i++) {
            ans[i] = Math.min(ans[i - 1] + cost[i - 1], ans[i - 2] + cost[i - 2]);
        }
        return ans[len];
    }

    public static void main(String[] args) {
        int[] x = {10, 15};
        System.out.println(new Solution746().minCostClimbingStairs(x));
    }
}

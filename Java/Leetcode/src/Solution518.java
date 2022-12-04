/**
 * @author 11214
 * @since 2022/12/4 11:21
 * <p>
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class Solution518 {
    public int change(int amount, int[] coins) {
        int[] ans = new int[amount + 1];
        ans[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                ans[i] += ans[i - coin];
            }
        }

        return ans[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(new Solution518().change(5, coins));
    }
}

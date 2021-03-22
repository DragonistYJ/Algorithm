/**
 * @author YuJian
 * @since 2021/3/22
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount + 1];
        ans[0] = 0;
        for (int i = 1; i <= amount; i++) {
            ans[i] = Integer.MAX_VALUE;
        }

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (ans[i-coin] != Integer.MAX_VALUE) {
                    ans[i] = Math.min(ans[i], ans[i - coin] + 1);
                }
            }
        }

        return ans[amount] == Integer.MAX_VALUE ? -1 : ans[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new Solution322().coinChange(coins,3));
    }
}

/**
 * @author 11214
 * @since 2022/12/6 18:09
 * <p>
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution309 {
    private int[][] memory;
    private int[] prices;

    /**
     * @param day   天数
     * @param state 0 持有股票； 1 不持有股票，处于冷冻期；2 不持有股票，不处于冷冻期
     */
    public int dfs(int day, int state) {
        if (day >= prices.length - 1) {
            return 0;
        }

        if (memory[day][state] != -1) {
            return memory[day][state];
        }

        int profit1 = 0;
        int profit2 = 0;
        if (state == 0) {
            profit1 = dfs(day + 1, 0); // 继续持有股票
            profit2 = dfs(day + 1, 1) + prices[day + 1]; // 卖掉
        } else if (state == 1) {
            profit2 = dfs(day + 1, 2); // 不买
        } else if (state == 2) {
            profit1 = dfs(day + 1, 0) - prices[day + 1]; // 买入
            profit2 = dfs(day + 1, 2); // 不买
        }
        memory[day][state] = Math.max(profit1, profit2);
        return memory[day][state];
    }

    public int maxProfit(int[] prices) {
        this.memory = new int[prices.length][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 3; j++) {
                this.memory[i][j] = -1;
            }
        }
        this.prices = prices;

        int profit1 = dfs(0, 0) - prices[0];
        int profit2 = dfs(0, 2);
        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(new Solution309().maxProfit(prices));
    }
}

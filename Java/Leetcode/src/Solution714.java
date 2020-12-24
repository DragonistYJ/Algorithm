/**
 * @ClassName Solution714
 * @Author 11214
 * @Date 2020/6/5
 * @Description 买入股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;
        int cash = 0;
        int hold = -prices[0];
        for (int price : prices) {
            cash = Math.max(cash, hold + price - fee);
            hold = Math.max(hold, cash - price);
        }
        return Math.max(cash, hold);
    }
}

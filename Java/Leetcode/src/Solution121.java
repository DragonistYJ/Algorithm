/*
NO121 买卖股票的最佳时机
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = prices[0];
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                ans = Math.max(max - min, ans);
                max = prices[i];
                min = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
                ans = Math.max(max - min, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {7, 6, 4, 3, 1};
        System.out.println(new Solution121().maxProfit(x));
    }
}

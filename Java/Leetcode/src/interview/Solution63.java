package interview;

/**
 * @ClassName Solution63
 * @Author 11214
 * @Date 2020/4/12
 * @Description TODO
 */
public class Solution63 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {2, 1, 2, 0, 1};
        System.out.println(new Solution63().maxProfit(prices));
    }
}

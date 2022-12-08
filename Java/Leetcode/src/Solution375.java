/**
 * @author 11214
 * @since 2022/12/8 10:09
 * <p>
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 我从 1 到 n 之间选择一个数字。
 * 你来猜我选了哪个数字。
 * 如果你猜到正确的数字，就会 赢得游戏 。
 * 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
 * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
 * 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
 */
public class Solution375 {
    public int getMoneyAmount(int n) {
        int[][] ans = new int[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            ans[i][i + 1] = i;
        }

        for (int range = 3; range <= n; range++) {
            for (int start = 1; start <= n - range + 1; start++) {
                int end = start + range - 1;
                int min = Integer.MAX_VALUE;
                for (int k = start; k <= end; k++) {
                    int left = k == start ? 0 : ans[start][k - 1];
                    int right = k == end ? 0 : ans[k + 1][end];
                    int money = k + Math.max(left, right);
                    min = Math.min(min, money);
                }
                ans[start][end] = min;
            }
        }

        return ans[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution375().getMoneyAmount(10));
    }
}

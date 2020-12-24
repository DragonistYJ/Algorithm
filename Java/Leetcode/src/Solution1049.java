/*
NO1049 最后一块石头的重量2
有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 */
public class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int j = sum / 2; j >= 0; j--) {
                if (dp[j] && j + stone < sum / 2 + 1) {
                    dp[j + stone] = true;
                }
            }
        }
        int half = 0;
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[i]) {
                half = i;
                break;
            }
        }

        return sum - half - half;
    }

    public static void main(String[] args) {
        int[] x = {6, 8, 10};
        System.out.println(new Solution1049().lastStoneWeightII(x));
    }
}

/*
NO1000 合并石子的最低成本
有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 */
public class Solution1000 {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if (K < n || (n - K) % (K - 1) != 0) return -1;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = stones[i];
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}

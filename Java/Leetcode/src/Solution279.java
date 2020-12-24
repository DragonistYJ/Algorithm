/*
NO279 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            int square = i * i;
            for (int j = n - square; j > 0; j--) {
                if (ans[j] != 0) {
                    int index = 1;
                    while (j + index * square <= n) {
                        ans[j + square * index] = ans[j + square * index] == 0 ? ans[j] + index : Math.min(ans[j + square * index], ans[j] + index);
                        index += 1;
                    }
                }
            }
            int index = 1;
            while (index * square <= n) {
                ans[square * index] = ans[square * index] == 0 ? index : Math.min(ans[square * index], index);
                index += 1;
            }
        }
        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution279().numSquares(24));
    }
}

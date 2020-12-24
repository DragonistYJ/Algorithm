/**
 * 等差数列划分
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，以下数列为等差数列:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 * 1, 1, 2, 5, 7
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P < Q < N 。
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 */
public class Solution413 {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n - 2; ) {
            int gap = A[i + 1] - A[i];
            int k = i + 2;
            while (k < n && A[k] - A[k - 1] == gap) k += 1;
            sum += (k - i - 1) * (k - i - 2) / 2;
            i = k - 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        System.out.println(new Solution413().numberOfArithmeticSlices(A));
    }
}

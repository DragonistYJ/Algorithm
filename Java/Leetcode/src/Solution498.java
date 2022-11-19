import java.util.Arrays;

/**
 * @author yujian
 * @since 2022/9/9 10:26
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int index = 0;
        int[] ans = new int[n * m];
        int sum = n + m - 2;
        for (int k = 0; k <= sum; k++) {
            for (int i = 0; i <= k; i++) {
                int j = k - i;
                int a = i;
                int b = j;
                if (k % 2 == 0) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                if (a >= n || b >= m) {
                    continue;
                }
                ans[index] = mat[a][b];
                index += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution498().findDiagonalOrder(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        )));
    }
}

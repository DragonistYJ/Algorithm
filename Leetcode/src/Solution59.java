/*
NO59 螺旋矩阵2
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int index = 1;
        int[][] ans = new int[n][n];
        while (index <= n * n) {
            for (int i = l; i <= r; i++) {
                ans[t][i] = index;
                index += 1;
            }
            t += 1;
            for (int i = t; i <= b; i++) {
                ans[i][r] = index;
                index += 1;
            }
            r -= 1;
            for (int i = r; i >= l; i--) {
                ans[b][i] = index;
                index += 1;
            }
            b -= 1;
            for (int i = b; i >= t; i--) {
                ans[i][l] = index;
                index += 1;
            }
            l += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = new Solution59().generateMatrix(5);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}


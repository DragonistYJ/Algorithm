import java.util.ArrayList;
import java.util.List;

/*
NO54 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new ArrayList<>();
        int m = matrix[0].length;
        if (m == 0) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>(n * m);
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        while (ans.size() < n * m) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top += 1;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right -= 1;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom -= 1;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left += 1;
        }
        while (ans.size() > n * m) ans.remove(ans.size() - 1);
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(new Solution54().spiralOrder(x));
    }
}

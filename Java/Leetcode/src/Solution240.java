/*
NO240 搜索二维矩阵2
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
 */
public class Solution240 {
    public boolean searchMatrix2(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            int rowMid = (top + bottom) / 2;
            int columnMid = (left + right) / 2;
            if (matrix[rowMid][columnMid] == target) {
                return true;
            } else if (target < matrix[rowMid - 1][columnMid] && target < matrix[rowMid][columnMid - 1]) {
                bottom = rowMid;
                right = columnMid;
            } else if (target < matrix[rowMid - 1][columnMid] && target > matrix[rowMid][columnMid + 1]) {
                bottom = rowMid;
                left = columnMid;
            } else if (target < matrix[rowMid][columnMid - 1] && target > matrix[rowMid + 1][columnMid]) {
                top = rowMid;
                right = columnMid;
            } else if (target > matrix[rowMid][columnMid + 1] && target > matrix[rowMid + 1][columnMid]) {
                top = rowMid;
                left = columnMid;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] > target) break;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > target) break;
                if (matrix[i][j] == target) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(new Solution240().searchMatrix2(x, 7));
    }
}

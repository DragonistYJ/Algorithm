package interview;

/**
 * @ClassName Solution4
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int i = 0;
        int j = matrix[0].length - 1;
        while (j >= 0 && i < matrix.length) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i += 1;
            } else if (target < matrix[i][j]) {
                j -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-5}};
        System.out.println(new Solution4().findNumberIn2DArray(matrix, -5));
    }
}

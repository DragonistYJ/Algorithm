import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName 将矩阵按对角线排序
 * @Author 11214
 * @Date 2020/4/18
 * @Description 给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
 */
public class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        if (n == 0) return new int[0][0];
        int m = mat[0].length;
        if (m == 0) return new int[n][0];
        List<List<Integer>> list = new ArrayList<>();
        int l = n + m - 1;
        for (int i = 0; i < l; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.get(i - j + m - 1).add(mat[i][j]);
            }
        }
        for (int i = 0; i < l; i++) {
            list.get(i).sort((o1, o2) -> o2 - o1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = i - j + m - 1;
                List<Integer> integerList = list.get(index);
                mat[i][j] = integerList.get(integerList.size() - 1);
                integerList.remove(integerList.size() - 1);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}};
        System.out.println(Arrays.deepToString(new Solution1329().diagonalSort(mat)));
    }
}

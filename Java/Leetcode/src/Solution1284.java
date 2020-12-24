import java.util.*;

/*
NO1284 转化为全零矩阵的最少反转次数
给你一个 m x n 的二进制矩阵 mat。
每一步，你可以选择一个单元格并将它反转（反转表示 0 变 1 ，1 变 0 ）。如果存在和它相邻的单元格，那么这些相邻的单元格也会被反转。（注：相邻的两个单元格共享同一条边。）
请你返回将矩阵 mat 转化为全零矩阵的最少反转次数，如果无法转化为全零矩阵，请返回 -1 。
二进制矩阵的每一个格子要么是 0 要么是 1 。
全零矩阵是所有格子都为 0 的矩阵。
 */
public class Solution1284 {
    private class Method {
        private List<Integer> matrix;
        private int step;

        public Method(List<Integer> matrix, int step) {
            this.matrix = matrix;
            this.step = step;
        }
    }

    public int minFlips(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        List<Integer> init = new ArrayList<>(n * m);
        for (int[] ints : mat) {
            for (int j = 0; j < m; j++) {
                init.add(ints[j]);
            }
        }
        List<Method> methods = new LinkedList<>();
        methods.add(new Method(new ArrayList<>(init), 0));
        Set<List<Integer>> matrixes = new HashSet<>();
        matrixes.add(new ArrayList<>(init));

        while (!methods.isEmpty()) {
            Method method = methods.get(0);
            methods.remove(0);
            List<Integer> matrix = method.matrix;
            if (!matrix.contains(1)) return method.step;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    List<Integer> flip = flip(matrix, i, j, n, m);
                    if (matrixes.contains(flip)) continue;
                    methods.add(new Method(new ArrayList<>(flip), method.step + 1));
                    matrixes.add(new ArrayList<>(flip));
                }
            }
        }

        return -1;
    }

    private List<Integer> flip(List<Integer> matrix, int i, int j, int n, int m) {
        List<Integer> mat = new ArrayList<>(matrix);
        mat.set(i * m + j, mat.get(i * m + j) ^ 1);
        if (i > 0) mat.set((i - 1) * m + j, mat.get((i - 1) * m + j) ^ 1);
        if (i < n - 1) mat.set((i + 1) * m + j, mat.get((i + 1) * m + j) ^ 1);
        if (j > 0) mat.set(i * m + j - 1, mat.get(i * m + j - 1) ^ 1);
        if (j < m - 1) mat.set(i * m + j + 1, mat.get(i * m + j + 1) ^ 1);
        return mat;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 1, 1}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(new Solution1284().minFlips(x));
    }
}

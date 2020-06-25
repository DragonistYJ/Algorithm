import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution962
 * @Author 11214
 * @Date 2020/6/25
 * @Description 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 */
public class Solution962 {
    private class Pair {
        private int value;
        private int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int maxWidthRamp(int[] A) {
        int n = A.length;
        List<Pair> pairs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(A[i], i));
        }
        pairs.sort(Comparator.comparingInt(o -> o.value));
        int[] maxIndexes = new int[n];
        maxIndexes[n - 1] = pairs.get(n - 1).index;
        for (int i = n - 2; i >= 0; i--) {
            maxIndexes[i] = Math.max(maxIndexes[i + 1], pairs.get(i).index);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, maxIndexes[i] - pairs.get(i).index);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {6, 0, 8, 2, 1, 5};
        System.out.println(new Solution962().maxWidthRamp(A));
    }
}

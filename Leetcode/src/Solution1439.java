import java.util.*;

/**
 * @ClassName Solution1439
 * @Author 11214
 * @Date 2020/6/2
 * @Description TODO
 */
public class Solution1439 {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<Integer> pre = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        PriorityQueue<Integer> next = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < m; i++) {
            pre.add(mat[0][i]);
        }
        for (int i = 1; i < n; i++) {
            next.clear();
            while (!pre.isEmpty()) {
                int top = pre.poll();
                for (int j = 0; j < m; j++) {
                    next.add(mat[i][j] + top);
                }
            }
            int range = Math.min(k, next.size());
            for (int j = 0; j < range; j++) {
                pre.add(next.poll());
            }
        }
        for (int i = 1; i < k; i++) {
            pre.poll();
        }
        return pre.poll();
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 10}, {2, 2, 9}};
        System.out.println(new Solution1439().kthSmallest(mat, 7));
    }
}

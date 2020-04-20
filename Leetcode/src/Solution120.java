import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
NO120 三角形最短路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;

        int[][] ans = new int[n + 1][n + 1];
        ans[1][1] = triangle.get(0).get(0);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    ans[i][j] = ans[i - 1][j] + triangle.get(i - 1).get(j - 1);
                } else if (j == i) {
                    ans[i][j] = ans[i - 1][j - 1] + triangle.get(i - 1).get(j - 1);
                } else {
                    ans[i][j] = Math.min(ans[i - 1][j], ans[i - 1][j - 1]) + triangle.get(i - 1).get(j - 1);
                }
            }
        }
        int ret = ans[n][1];
        for (int i = 1; i <= n; i++) {
            ret = Math.min(ans[n][i], ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Solution120().minimumTotal(list));
    }
}

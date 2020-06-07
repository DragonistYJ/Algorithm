import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution546
 * @Author 11214
 * @Date 2020/6/7
 * @Description 移除盒子
 * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
 */
public class Solution546 {
    public int dfs(int[] boxes, int[][][] memory, int l, int r, int k) {
        if (l > r) return 0;
        if (memory[l][r][k] != 0) return memory[l][r][k];
        while (r > l && boxes[r] == boxes[r - 1]) {
            r -= 1;
            k += 1;
        }
        memory[l][r][k] = dfs(boxes, memory, l, r - 1, 0) + (k + 1) * (k + 1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                memory[l][r][k] = Math.max(memory[l][r][k], dfs(boxes, memory, i + 1, r - 1, 0) + dfs(boxes, memory, l, i, k + 1));
            }
        }
        return memory[l][r][k];
    }

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] memory = new int[n][n][n];
        return dfs(boxes, memory, 0, n - 1, 0);
    }

    public static void main(String[] args) {
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(new Solution546().removeBoxes(boxes));
    }
}

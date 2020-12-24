import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution1140
 * @Author 11214
 * @Date 2020/4/28
 * @Description 石子游戏2
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 * 游戏一直持续到所有石子都被拿走。
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 */
public class Solution1140 {
    private int dfs(int i, int m, int[][] memory, int[] sums, int n) {
        if (memory[i][m] != -1) return memory[i][m];

        if (i >= n) return 0;
        if (i + 2 * m >= n) return sums[i];
        int max = 0;
        for (int j = 1; j <= 2 * m; j++) {
            max = Math.max(max, sums[i] - dfs(i + j, Math.max(j, m), memory, sums, n));
        }
        memory[i][m] = max;
        return max;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memory = new int[n][2 * n];
        for (int[] ints : memory) Arrays.fill(ints, -1);
        int[] sums = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sums[i] = sums[i + 1] + piles[i];
        }
        return dfs(0, 1, memory, sums, n);
    }

    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        System.out.println(new Solution1140().stoneGameII(piles));
    }
}

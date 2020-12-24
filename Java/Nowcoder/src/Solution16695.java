import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName 数的划分
 * @Author 11214
 * @Date 2020/4/3
 * @Description dfs
 */
public class Solution16695 {
    private static int[][] memories;
    private static int n;
    private static int k;

    private static int dfs(int number, int step, int sum) {
        if (sum > n) return 0;
        if (sum == n) {
            if (step == k) return 1;
            else return 0;
        }
        if (step >= k) return 0;
        if (memories[n - sum][k - step] != -1) return memories[n - sum][k - step];

        int tmp = 0;
        for (int i = number + 1; i < n; i++) {
            tmp += dfs(i, step + 1, sum + i);
        }
        if (tmp != 0) memories[n - sum][k - step] = tmp;
        return tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        memories = new int[n + 1][k + 1];
        for (int[] memory : memories) {
            Arrays.fill(memory, -1);
        }
        dfs(-1, 0, 0);
        System.out.println(dfs(-1, 0, 0));
    }
}

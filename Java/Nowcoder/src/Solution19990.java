import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Solution19990
 * @Author 11214
 * @Date 2020/4/22
 * @Description TODO
 */
public class Solution19990 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int begin = scanner.nextInt();
        int max = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        boolean[][] reachable = new boolean[n + 1][max + 1];
        reachable[0][begin] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= max; j++) {
                if (reachable[i][j]) {
                    if (j + a[i] <= max) reachable[i + 1][j + a[i]] = true;
                    if (j - a[i] >= 0) reachable[i + 1][j - a[i]] = true;
                }
            }
        }

        for (int i = max; i >= 0; i--) {
            if (reachable[n][i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}

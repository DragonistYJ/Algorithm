import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Solution21467
 * @Author 11214
 * @Date 2020/4/22
 * @Description TODO
 */
public class Solution21467 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            if (a[0] == 1) {
                System.out.println(1);
                continue;
            }
            boolean[] value = new boolean[a[n - 1] + 1];
            value[0] = true;
            for (int k = 0; k < n; k++) {
                if (a[k] != 0) {
                    for (int i = value.length - 1; i >= 0; i--) {
                        if (value[i]) {
                            for (int j = i + a[k]; j < value.length; j += a[k]) value[j] = true;
                        }
                    }
                }
                for (int i = k + 1; i < n; i++) {
                    if (value[a[i]]) a[i] = 0;
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != 0) ans += 1;
            }
            System.out.println(ans);
        }
    }
}

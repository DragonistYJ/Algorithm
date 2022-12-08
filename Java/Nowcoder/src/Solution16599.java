import java.util.Scanner;

/**
 * @author 11214
 * @since 2022/12/8 11:56
 */
public class Solution16599 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        int ans = 0;
        for (int i = left; i <= right; i++) {
            int k = i;
            while (k != 0) {
                int j = k % 10;
                if (j == 2) {
                    ans += 1;
                }
                k /= 10;
            }
        }
        System.out.println(ans);
    }
}

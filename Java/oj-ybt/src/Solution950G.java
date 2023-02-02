import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/2 14:10
 */
public class Solution950G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }

        long cache = 0;
        int ans = 1;
        for (long number : numbers) {
            if (cache + number <= m) {
                cache += number;
            } else {
                ans += 1;
                cache = number;
            }
        }
        System.out.println(ans);
    }
}
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/2/2 11:15
 */
public class Solution950K {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        long sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        long average = sum / n;

        long ans = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= average) {
                continue;
            }
            int step = 1;
            while (numbers[i] < average && step * 2 <= n) {
                int left = (i - step + n) % n;
                if (numbers[left] > average) {
                    long gap = Math.min(average - numbers[i], numbers[left] - average);
                    ans += gap * step;
                    numbers[i] += gap;
                    numbers[left] -= gap;
                }
                if (numbers[i] == average) {
                    continue;
                }
                int right = (i + step) % n;
                if (numbers[right] > average) {
                    long gap = Math.min(average - numbers[i], numbers[right] - average);
                    ans += gap * step;
                    numbers[i] += gap;
                    numbers[right] -= gap;
                }

                step += 1;
            }
        }
        System.out.println(ans);
    }
}

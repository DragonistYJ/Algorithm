import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/3/4 14:55
 */
public class Solution978B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            boolean flag = true;
            for (Integer prime : primes) {
                if (i % prime == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primes.add(i);

                if (n % i == 0) {
                    System.out.println(n / i);
                    break;
                }
            }
        }
    }
}

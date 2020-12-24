import java.util.Scanner;

/**
 * @ClassName Solution16574
 * @Author 11214
 * @Date 2020/4/1
 * @Description TODO
 */
public class Solution16574 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long sqrt = (long) Math.sqrt(l);
        for (long i = 2; i <= sqrt; i++) {
            if (l % i == 0) System.out.println(l / i);
        }
    }
}

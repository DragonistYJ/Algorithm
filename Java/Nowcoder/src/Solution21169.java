import java.util.Scanner;

/**
 * @ClassName Solution21169
 * @Author 11214
 * @Date 2020/4/20
 * @Description TODO
 */
public class Solution21169 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }

        long a = 1;
        long b = 1;
        while (n > 2) {
            long c = a + b;
            b = a;
            a = c;
            n--;
        }
        System.out.println(a);
    }
}

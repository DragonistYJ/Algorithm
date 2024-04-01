import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/3/5 19:47
 */
public class Solution983A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n == k + 1 || n % (k + 1) == 0) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }
    }
}

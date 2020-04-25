import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName Solution16642
 * @Author 11214
 * @Date 2020/4/25
 * @Description TODO
 */
public class Solution16642 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE).multiply(BigInteger.valueOf(2)).toString());
    }
}

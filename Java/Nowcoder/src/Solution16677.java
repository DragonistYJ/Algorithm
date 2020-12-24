import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName Solution16677
 * @Author 11214
 * @Date 2020/4/25
 * @Description TODO
 */
public class Solution16677 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger integer = new BigInteger(scanner.next());
        double v = Math.log(2) / Math.log(10) * integer.longValue() + 1;
        System.out.println((long) v);
        StringBuilder builder = new StringBuilder("1");
        for (int i = 0; i < 500; i++) {
            builder.append(0);
        }
        BigInteger mod = new BigInteger(builder.toString());
        BigInteger pow = BigInteger.valueOf(2).modPow(integer, mod).subtract(BigInteger.ONE);
        builder = new StringBuilder(pow.toString());
        builder.reverse();
        while (builder.length() < 500) {
            builder.append(0);
        }
        builder.reverse();
        String ans = builder.toString();
        for (int i = 0; i < 10; i++) {
            System.out.println(ans.substring(i * 50, i * 50 + 50));
        }
    }
}

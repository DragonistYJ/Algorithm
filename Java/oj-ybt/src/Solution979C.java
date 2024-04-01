import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2023/3/4 21:12
 */
public class Solution979C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        while (b.compareTo(BigInteger.ZERO) != 0) {
            BigInteger c = a.mod(b);
            a = b;
            b = c;
        }
        System.out.println(a);
    }
}

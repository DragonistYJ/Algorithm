import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yujian
 * @since 2023/7/16 16:20
 */
public class Solution996C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        BigInteger p = sc.nextBigInteger();
        BigInteger res = a.multiply(b).mod(p);
        System.out.println(res);
    }
}

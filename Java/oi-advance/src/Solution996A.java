import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yujian
 * @since 2023/7/16 16:15
 */
public class Solution996A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        BigInteger p = sc.nextBigInteger();
        BigInteger res = a.modPow(b, p);
        System.out.println(res);
    }
}

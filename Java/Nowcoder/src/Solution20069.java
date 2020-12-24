import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName Solution20069
 * @Author 11214
 * @Date 2020/4/2
 * @Description TODO
 */
public class Solution20069 {
    public static void main(String[] args) {
        BigInteger MOD = new BigInteger("100003");
        Scanner scanner = new Scanner(System.in);
        BigInteger m = scanner.nextBigInteger();
        BigInteger n = scanner.nextBigInteger();
        BigInteger pow1 = m.modPow(n, MOD);
        BigInteger pow2 = m.subtract(BigInteger.ONE).modPow(n.subtract(BigInteger.ONE), MOD).multiply(m).mod(MOD);
        System.out.println(pow1.subtract(pow2).add(MOD).mod(MOD).longValue());
    }
}

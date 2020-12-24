import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName Solution14718
 * @Author 11214
 * @Date 2020/4/1
 * @Description TODO
 */
public class Solution14718 {
    private static long mod = 1000000007;

    private static long quickPower(long a, long b) {
        if (b == 1) return a;
        if (b % 2 == 0) {
            return quickPower(a * a % mod, b / 2) % mod;
        } else {
            return quickPower(a * a % mod, b / 2) * a % mod;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger m;
        BigInteger n;
        n = scanner.nextBigInteger();
        m = scanner.nextBigInteger();

        BigInteger t1 = m.modPow(n, BigInteger.valueOf(mod));
        BigInteger t2 = m.subtract(BigInteger.valueOf(1));
        BigInteger t3 = t2.modPow(n.subtract(BigInteger.valueOf(1)), BigInteger.valueOf(mod));
        BigInteger t4 = t3.multiply(m).mod(BigInteger.valueOf(mod));
        BigInteger result = t1.subtract(t4).mod(BigInteger.valueOf(mod));
        System.out.println(result.longValue());
    }
}

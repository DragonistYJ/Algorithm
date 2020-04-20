import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName 序列求和
 * @Author 11214
 * @Date 2020/4/3
 * @Description 逆元
 * 定义S(n) = 12 + 22 + … + n2，输出S(n) % 1000000007。
 * 注意：1 < n < 1e18。
 */
public class Solution15950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger MOD = BigInteger.valueOf(1000000007);
        while (scanner.hasNext()) {
            BigInteger n = scanner.nextBigInteger();
            System.out.println(n.multiply(n.add(BigInteger.ONE)).multiply(n.add(n).add(BigInteger.ONE)).divide(BigInteger.valueOf(6)).mod(MOD).longValue());
        }
    }
}

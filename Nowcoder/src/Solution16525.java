import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName 转圈游戏
 * @Author 11214
 * @Date 2020/4/2
 * @Description 快速幂
 */
public class Solution16525 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger(); // 几个人
        BigInteger m = scanner.nextBigInteger(); // 走几步
        BigInteger k = scanner.nextBigInteger(); // 10的K次方轮
        BigInteger x = scanner.nextBigInteger(); // 几号位的人

        System.out.println(BigInteger.TEN.modPow(k, n).multiply(m).add(x).mod(n).longValue());
    }
}

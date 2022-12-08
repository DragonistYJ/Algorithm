import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 11214
 * @since 2022/12/8 13:55
 * <p>
 * 给定一个整数N（0≤N≤10000），求取N的阶乘
 */
public class Solution15064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (scanner.hasNextInt()) { // 注意 while 处理多个 case
            int n = scanner.nextInt();
            BigInteger x = new BigInteger("1");
            for (int i = 1; i <= n; i++) {
                x = x.multiply(new BigInteger(String.valueOf(i)));
            }
            System.out.println(x);
        }
    }
}

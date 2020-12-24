import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName 吴老板的课
 * @Author 11214
 * @Date 2020/4/3
 * @Description 逆元，卡特兰数
 */
public class Solution21507 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger ans = BigInteger.ONE;
        BigInteger number = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger coefficient = BigInteger.valueOf(i).multiply(BigInteger.valueOf(4)).subtract(BigInteger.valueOf(2));
            number = number.multiply(coefficient).divide(BigInteger.valueOf(i).add(BigInteger.ONE));
            ans = ans.add(number);
        }
        ans = ans.mod(BigInteger.valueOf(100000007));
        System.out.println(ans.longValue());
    }
}

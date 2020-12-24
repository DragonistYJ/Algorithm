import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName 水仙花数
 * @Author 11214
 * @Date 2020/4/1
 * @Description 数学
 */
public class Solution14386 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.clear();
            long number = scanner.nextLong();
            long tmp = number;
            while (tmp != 0) {
                list.add(tmp % 10);
                tmp /= 10;
            }
            long sum = 0;
            for (Long aLong : list) {
                sum += Math.pow(aLong, list.size());
            }
            if (sum != number) System.out.println("no");
            else System.out.println("yes");
        }
    }
}

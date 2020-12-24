import java.util.Scanner;

/**
 * @ClassName 比例化简
 * @Author 11214
 * @Date 2020/4/1
 * @Description TODO
 */
public class Solution16501 {
    private static boolean prime(long a, long b) {
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        int l = scanner.nextInt();
        double percent = a * 1.0 / b;

        long ansA = 0;
        long ansB = 0;
        double c = Double.MAX_VALUE;
        for (long i = 1; i <= l; i++) {
            long tmpA = (long) Math.ceil(i * percent);
            if (tmpA > l || !prime(i, tmpA)) continue;
            double tmpC = Math.abs(tmpA * 1.0 / i - percent);
            if (Double.compare(tmpC, c) < 0) {
                c = tmpC;
                ansA = tmpA;
                ansB = i;
            }
        }

        System.out.println(ansA + " " + ansB);
    }
}

package interview;

/**
 * @ClassName Solution16
 * @Author 11214
 * @Date 2020/4/13
 * @Description TODO
 */
public class Solution16 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }

        double ans = 1;
        while (m != 0) {
            if (m % 2 == 1) ans *= x;
            x *= x;
            m /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution16().myPow(2, -2147483648));
    }
}

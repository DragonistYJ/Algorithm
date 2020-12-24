import com.sun.org.apache.bcel.internal.generic.ARETURN;

/*
NO50 Pow(x,n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (n < 0) return pow(1 / x, -(long) n);
        else if (n > 0) return pow(x, n);
        else return 1;
    }

    private double pow(double x, long n) {
        if (n == 1) return x;

        double ans = pow(x, n / 2);
        if (n % 2 == 0) return ans * ans;
        else return ans * ans * x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(1, -2147483648));
    }
}

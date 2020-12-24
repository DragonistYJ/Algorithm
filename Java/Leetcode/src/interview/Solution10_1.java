package interview;

/**
 * @ClassName Solution10_1
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution10_1 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 1;
        int b = 1;
        int mod = 1000000007;
        while (n > 2) {
            int c = (a + b) % mod;
            b = a;
            a = c;
            n -= 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution10_1().fib(5));
    }
}

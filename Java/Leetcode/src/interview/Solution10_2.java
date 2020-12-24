package interview;

/**
 * @ClassName Solution10_2
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution10_2 {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 2;
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
        System.out.println(new Solution10_2().numWays(7));
    }
}

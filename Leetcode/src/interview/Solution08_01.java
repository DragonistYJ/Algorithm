package interview;

/**
 * @ClassName Solution08_10
 * @Author 11214
 * @Date 2020/4/22
 * @Description TODO
 */
public class Solution08_01 {
    public int waysToStep(int n) {
        int mod = 1000000007;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        int a = 4;
        int b = 2;
        int c = 1;
        int d;
        while (n-- > 3) {
            d = ((a + b) % mod + c) % mod;
            c = b;
            b = a;
            a = d;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution08_01().waysToStep(5));
    }
}

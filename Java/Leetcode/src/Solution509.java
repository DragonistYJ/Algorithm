/**
 * @author yujian
 * @since 2022/8/14 10:16
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 */
public class Solution509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

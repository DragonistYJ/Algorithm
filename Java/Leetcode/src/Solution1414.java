import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2022/11/19 10:01
 * <p>
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * 斐波那契数字定义为：
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 */
public class Solution1414 {
    public int findMinFibonacciNumbers(int k) {
        List<Long> fibo = new ArrayList<>();
        fibo.add(1L);
        fibo.add(1L);
        while (true) {
            int n = fibo.size();
            long t = fibo.get(n - 1) + fibo.get(n - 2);
            if (t > k) {
                break;
            } else {
                fibo.add(t);
            }
        }
        int ans = 0;
        for (int i = fibo.size() - 1; i >= 0; i--) {
            if (fibo.get(i) <= k) {
                ans += 1;
                k -= fibo.get(i);
            }
            if (k == 0) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1414().findMinFibonacciNumbers(19));
    }
}

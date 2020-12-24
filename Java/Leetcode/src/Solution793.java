/**
 * 阶乘函数后K个零
 * f(x) 是 x! 末尾是0的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且0! = 1）
 * 例如， f(3) = 0 ，因为3! = 6的末尾没有0；而 f(11) = 2 ，因为11!= 39916800末端有2个0。给定 K，找出多少个非负整数x ，有 f(x) = K 的性质。
 */
public class Solution793 {
    public int preimageSizeFZF(long K) {
        long lo = K, hi = 10*K + 1;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            long zmi = zeta(mi);
            if (zmi == K) return 5;
            else if (zmi < K) lo = mi + 1;
            else hi = mi;
        }
        return 0;
    }

    public long zeta(long x) {
        if (x == 0) return 0;
        return x/5 + zeta(x/5);
    }
}

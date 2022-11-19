/**
 * @author yujian
 * @since 2022/9/7 16:16
 * 给你一个整数total，表示你拥有的总钱数。同时给你两个整数cost1和cost2，分别表示一支钢笔和一支铅笔的价格。
 * 你可以花费你部分或者全部的钱，去买任意数目的两种笔。
 * 请你返回购买钢笔和铅笔的不同方案数目。
 */
public class Solution2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        long max1 = total / cost1;
        for (long i = 0; i <= max1; i++) {
            ans += (total - i * cost1) / cost2 + 1;
        }
        return ans;
    }
}

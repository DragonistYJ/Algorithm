import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Solution1387
 * @Author 11214
 * @Date 2020/6/4
 * @Description 将整数按权重排序
 * 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
 * 如果 x 是偶数，那么 x = x / 2
 * 如果 x 是奇数，那么 x = 3 * x + 1
 * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
 * 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 * 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
 */
public class Solution1387 {
    private int weight(int x) {
        int weight = 0;
        while (x != 1) {
            if (x % 2 == 0) x = x / 2;
            else x = x * 3 + 1;
            weight += 1;
        }
        return weight;
    }

    public int getKth(int lo, int hi, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            hashMap.put(i, weight(i));
            list.add(i);
        }
        list.sort((o1, o2) -> hashMap.get(o1).equals(hashMap.get(o2)) ? o1 - o2 : hashMap.get(o1) - hashMap.get(o2));
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution1387().getKth(7, 11, 4));
    }
}

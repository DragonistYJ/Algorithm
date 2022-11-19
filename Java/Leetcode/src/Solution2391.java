import java.util.ArrayList;
import java.util.List;

/**
 * @author yujian
 * @since 2022/9/5 15:33
 * 给你一个下标从 0开始的字符串数组garbage，其中garbage[i]表示第 i 个房子的垃圾集合。
 * garbage[i]只包含字符'M'，'P'和'G'，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。
 * 垃圾车收拾 一单位的任何一种垃圾都需要花费1分钟。
 * 同时给你一个下标从 0开始的整数数组travel，其中travel[i]是垃圾车从房子 i行驶到房子 i + 1 需要的分钟数。
 * 城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0出发，按顺序到达每一栋房子。但它们不是必须到达所有的房子。
 * 任何时刻只有 一辆垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车不能做任何事情。
 * 请你返回收拾完所有垃圾需要花费的 最少总分钟数。
 */
public class Solution2391 {
    private int calculate(String[] garbage, int[] travel, char type) {
        int n = garbage.length;
        List<Integer> list = new ArrayList<>(n);
        for (String s : garbage) {
            int m = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == type) {
                    m += 1;
                }
            }
            list.add(m);
        }
        n -= 1;
        while (n >= 0 && list.get(n) == 0) {
            n -= 1;
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += list.get(i);
            if (i != n) {
                sum += travel[i];
            }
        }
        return sum;
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int m = calculate(garbage, travel, 'M');
        int p = calculate(garbage, travel, 'P');
        int g = calculate(garbage, travel, 'G');
        return m + p + g;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2391().garbageCollection(
                new String[]{"G", "P", "GP", "GG"},
                new int[]{2, 4, 3}
        ));
    }
}

import java.util.*;

/**
 * @author yujian
 * @since 2022/8/14 10:25
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 */
public class Solution1646 {
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                list.add(list.get(i / 2));
            } else {
                int k = i / 2;
                list.add(list.get(k) + list.get(k+1));
            }
        }
        return Collections.max(list);
    }
}

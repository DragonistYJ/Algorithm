import java.util.TreeSet;

/**
 * @author yujian
 * @since 2023/7/20 11:47
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 */
public class Solution414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        if (set.size() < 3) {
            return set.last();
        }
        return set.first();
    }
}

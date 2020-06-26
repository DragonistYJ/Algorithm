import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution219
 * @Author 11214
 * @Date 2020/6/26
 * @Description 存在重复元素2
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 */
public class Solution219 {
    private class Pair {
        private int value;
        private int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        List<Pair> pairs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(nums[i], i));
        }
        pairs.sort((o1, o2) -> o1.value == o2.value ? o1.index - o2.index : o1.value - o2.value);
        for (int i = 0; i < n - 1; i++) {
            if (pairs.get(i).value == pairs.get(i + 1).value && pairs.get(i + 1).index - pairs.get(i).index <= k)
                return true;
        }
        return false;
    }
}

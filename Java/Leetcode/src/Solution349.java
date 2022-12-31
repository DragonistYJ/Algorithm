import java.util.HashSet;

/**
 * @author 11214
 * @since 2022/12/31 11:36
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int i = 0;
        for (Integer integer : set1) {
            ans[i] = integer;
            i += 1;
        }
        return ans;
    }
}

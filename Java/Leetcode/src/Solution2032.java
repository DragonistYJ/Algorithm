import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 11214
 * @since 2022/12/29 14:22
 * <p>
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 */
public class Solution2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        HashSet<Integer> set3 = new HashSet<>();
        for (int i : nums3) {
            set3.add(i);
        }
        HashSet<Integer> ans = new HashSet<>();
        for (Integer i : set1) {
            if (set2.contains(i) || set3.contains(i)) {
                ans.add(i);
            }
        }
        for (Integer i : set2) {
            if (set3.contains(i)) {
                ans.add(i);
            }
        }
        return new ArrayList<>(ans);
    }
}

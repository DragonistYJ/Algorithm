import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 11214
 * @since 2023/1/5 20:56
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        List<Integer> prefixes = new ArrayList<>();
        prefixes.add(0);
        for (int num : nums) {
            prefixes.add(prefixes.get(prefixes.size() - 1) + num);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefixes.size(); i++) {
            int t = prefixes.get(i) % k;
            if (map.containsKey(t)) {
                if (i - map.get(t) > 1) {
                    return true;
                }
            } else {
                map.put(t, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution523().checkSubarraySum(new int[]{0}, 1));
    }
}

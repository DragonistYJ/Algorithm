import java.util.*;

/**
 * @author 11214
 * @since 2022/8/29 11:08
 * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 */
public class Solution220 {
    public long bowId(int num, int t) {
        if (num >= 0) {
            return num / (t + 1);
        } else {
            return (num + 1) / (t + 1) - 1;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long id = bowId(nums[i], t);
            if (map.containsKey(id)) {
                return true;
            } else if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) <= t) {
                return true;
            } else if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) <= t) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(bowId(nums[i - k], t));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution220 solution220 = new Solution220();
        System.out.println(solution220.containsNearbyAlmostDuplicate(new int[]{2147483640, 2147483641}, 1, 100));
    }
}

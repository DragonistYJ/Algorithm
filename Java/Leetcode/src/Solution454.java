import java.util.HashMap;
import java.util.Map;

/**
 * @author 11214
 * @since 2023/1/6 15:30
 */
public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i1 : nums1) {
            for (int i2 : nums2) {
                int k = i1 + i2;
                map1.put(k, map1.getOrDefault(k, 0) + 1);
            }
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i1 : nums3) {
            for (int i2 : nums4) {
                int k = i1 + i2;
                map2.put(k, map2.getOrDefault(k, 0) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> kv1 : map1.entrySet()) {
            for (Map.Entry<Integer, Integer> kv2 : map2.entrySet()) {
                if (kv1.getKey() + kv2.getKey() == 0) {
                    ans += kv1.getValue() * kv2.getValue();
                }
            }
        }
        return ans;
    }
}

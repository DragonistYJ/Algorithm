import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yujian
 * @since 2023/7/20 10:53
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int k = nums.length / 3;
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

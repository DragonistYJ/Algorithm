import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author 11214
 * @since 2023/4/4 11:21
 */
public class Solution60 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        TreeSet<Map.Entry<Integer, Integer>> tree = new TreeSet<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            } else {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            tree.add(entry);
            if (tree.size() > k) {
                tree.pollLast();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : tree) {
            ans[i] = entry.getKey();
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution60 solution = new Solution60();
        solution.topKFrequent(new int[]{1, 2}, 2);
    }
}

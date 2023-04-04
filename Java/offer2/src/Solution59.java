import java.util.Map;
import java.util.TreeMap;

/**
 * @author 11214
 * @since 2023/4/4 11:08
 */
public class Solution59 {
    class KthLargest {
        private final int k;
        private final TreeMap<Integer, Integer> tree;
        private int cnt;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.tree = new TreeMap<>((o1, o2) -> o2 - o1);
            for (int num : nums) {
                this.add(num);
            }
        }

        public int add(int val) {
            this.tree.put(val, this.tree.getOrDefault(val, 0) + 1);
            this.cnt += 1;
            if (this.cnt > this.k) {
                Map.Entry<Integer, Integer> entry = this.tree.lastEntry();
                if (entry.getValue() == 1) {
                    this.tree.pollLastEntry();
                } else {
                    this.tree.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            return this.tree.lastKey();
        }
    }
}

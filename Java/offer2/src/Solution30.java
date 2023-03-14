import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author 11214
 * @since 2023/3/14 10:25
 */
public class Solution30 {
    static class RandomizedSet {
        private final HashMap<Integer, Integer> keyIndex;
        private final List<Integer> values;
        private final Random random;

        public RandomizedSet() {
            keyIndex = new HashMap<>();
            values = new ArrayList<>(100000);
            random = new Random();
        }

        public boolean insert(int val) {
            if (keyIndex.containsKey(val)) {
                return false;
            } else {
                values.add(val);
                keyIndex.put(val, values.size() - 1);
                return true;
            }
        }

        public boolean remove(int val) {
            if (keyIndex.containsKey(val)) {
                int idx = keyIndex.get(val);
                int last = values.get(values.size() - 1);
                values.set(idx, values.get(values.size() - 1));
                keyIndex.put(last, idx);
                values.remove(values.size() - 1);
                keyIndex.remove(val);
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            int idx = random.nextInt(values.size());
            return values.get(idx);
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(3));
        System.out.println(set.remove(3));
        System.out.println(set.remove(0));
        System.out.println(set.insert(3));
        System.out.println(set.getRandom());
        System.out.println(set.remove(0));
    }
}

import java.util.HashMap;

/**
 * @author 11214
 * @since 2023/3/14 9:38
 */
public class Solution31 {
    static class LRUCache {
        private final int capacity;
        private final HashMap<Integer, Integer> map;
        private final int[] queue;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            queue = new int[capacity];
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int size = map.size();
                int i = 0;
                while (i < size && queue[i] != key) {
                    i += 1;
                }
                for (; i < size - 1; i++) {
                    queue[i] = queue[i + 1];
                }
                queue[size - 1] = key;
            }
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                int size = map.size();
                int i = 0;
                while (i < size && queue[i] != key) {
                    i += 1;
                }
                for (; i < size - 1; i++) {
                    queue[i] = queue[i + 1];
                }
                queue[size - 1] = key;
                map.put(key, value);
            } else {
                if (map.size() < capacity) {
                    queue[map.size()] = key;
                } else {
                    map.remove(queue[0]);
                    for (int i = 0; i < capacity - 1; i++) {
                        queue[i] = queue[i + 1];
                    }
                    queue[capacity - 1] = key;
                }
                map.put(key, value);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

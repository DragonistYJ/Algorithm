import java.util.HashMap;

/**
 * @ClassName Solution677
 * @Author 11214
 * @Date 2020/6/12
 * @Description TODO
 */
public class Solution677 {
    private class MapSum {
        private HashMap<String, Integer> hashMap;
        private HashMap<String, Integer> prefixMap;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            this.hashMap = new HashMap<>();
            this.prefixMap = new HashMap<>();
        }

        public void insert(String key, int val) {
            if (!hashMap.containsKey(key)) {
                for (int i = 1; i <= key.length(); i++) {
                    String prefix = key.substring(0, i);
                    prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + val);
                }
            } else {
                int pre = hashMap.get(key);
                for (int i = 1; i <= key.length(); i++) {
                    String prefix = key.substring(0, i);
                    prefixMap.put(prefix, prefixMap.get(key) - pre + val);
                }
            }
            hashMap.put(key, val);
        }

        public int sum(String prefix) {
            return prefixMap.getOrDefault(prefix, 0);
        }
    }
}

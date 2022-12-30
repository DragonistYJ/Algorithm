import java.util.HashMap;
import java.util.Map;

/**
 * @author 11214
 * @since 2022/12/30 15:17
 * <p>
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> timeMap = new HashMap<>();
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            timeMap.put(c, timeMap.getOrDefault(c, 0) + 1);
            if (!indexMap.containsKey(c)) {
                indexMap.put(c, i);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> kv : timeMap.entrySet()) {
            Character key = kv.getKey();
            Integer value = kv.getValue();
            if (value == 1) {
                ans = Math.min(ans, indexMap.get(key));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

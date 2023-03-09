import java.util.HashMap;

/**
 * @author 11214
 * @since 2023/3/9 9:37
 */
public class Solution16 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int idx = 0;
        HashMap<Character, Integer> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (positions.containsKey(c)) {
                Integer position = positions.get(c);
                if (position >= idx) {
                    idx = position + 1;
                }
            }
            ans = Math.max(ans, i - idx + 1);
            positions.put(c, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution16().lengthOfLongestSubstring("bbbbb"));
    }
}

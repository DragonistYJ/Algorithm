import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 11214
 * @since 2022/12/31 11:25
 */
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> wordSet = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            } else {
                if (wordSet.contains(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
                wordSet.add(words[i]);
            }
        }
        return true;
    }
}

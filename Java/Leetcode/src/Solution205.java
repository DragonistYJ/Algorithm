import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 11214
 * @since 2022/8/31 9:41
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> exists = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (exists.contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                exists.add(t.charAt(i));
            }
        }
        return true;
    }
}

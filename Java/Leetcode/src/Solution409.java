import java.util.HashMap;

/**
 * @author 11214
 * @since 2022/11/18 14:46
 * <p>
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 */
public class Solution409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean remainder = false;
        int ans = 0;
        for (Character key : map.keySet()) {
            int len = map.get(key);
            if (len % 2 == 0) {
                ans += len;
            } else {
                ans += len - 1;
                remainder = true;
            }
        }
        if (remainder) {
            ans += 1;
        }
        return ans;
    }
}

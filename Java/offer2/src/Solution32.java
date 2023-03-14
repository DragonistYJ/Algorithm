/**
 * @author 11214
 * @since 2023/3/14 9:34
 */
public class Solution32 {
    public boolean isAnagram(String s, String t) {
        int[] bitMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bitMap[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            bitMap[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (bitMap[i] != 0) {
                return false;
            }
        }
        return !s.equals(t);
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/9 10:00
 */
public class Solution15 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        int[] count1 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count1[p.charAt(i) - 'a'] += 1;
        }
        int[] count2 = new int[26];
        for (int i = 0; i < p.length() - 1; i++) {
            count2[s.charAt(i) - 'a'] += 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = p.length() - 1; i < s.length(); i++) {
            count2[s.charAt(i) - 'a'] += 1;
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (count1[j] != count2[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(i - p.length() + 1);
            }
            count2[s.charAt(i - p.length() + 1) - 'a'] -= 1;
        }
        return ans;
    }
}

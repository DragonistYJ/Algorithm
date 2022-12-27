package competition.week324;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yujian
 * @since 2022/12/18 10:30
 */
public class Solution6265 {
    public int similarPairs(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
            list.add(set.toString());
        }
        int ans = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (list.get(i).equals(list.get(j))) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aabb", "ab", "ba"};
        System.out.println(new Solution6265().similarPairs(words));
    }
}

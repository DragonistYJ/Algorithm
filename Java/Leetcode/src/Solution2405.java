import java.util.HashSet;

/**
 * @author 11214
 * @since 2022/11/18 16:02
 * <p>
 * 给你一个字符串 s ，请你将该字符串划分成一个或多个 子字符串 ，并满足每个子字符串中的字符都是 唯一 的。也就是说，在单个子字符串中，字母的出现次数都不超过 一次 。
 * 满足题目要求的情况下，返回 最少 需要划分多少个子字符串。
 * 注意，划分后，原字符串中的每个字符都应该恰好属于一个子字符串。
 */
public class Solution2405 {
    public int partitionString(String s) {
        int ans = 1;
        HashSet<Character> exists = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (exists.contains(s.charAt(i))) {
                exists.clear();
                ans += 1;
            }
            exists.add(s.charAt(i));
        }
        return ans;
    }
}

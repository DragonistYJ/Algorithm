/**
 * @author 11214
 * @since 2022/11/20 10:34
 * <p>
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 */
public class Solution1221 {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                left += 1;
            } else {
                right += 1;
            }
            if (left == right) {
                ans += 1;
                left = 0;
                right = 0;
            }
        }
        return ans;
    }
}

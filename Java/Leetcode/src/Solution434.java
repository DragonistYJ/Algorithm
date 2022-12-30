/**
 * @author 11214
 * @since 2022/12/30 15:13
 * <p>
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 */
public class Solution434 {
    public int countSegments(String s) {
        String[] split = s.split(" ");
        int ans = 0;
        for (String ss : split) {
            if (!ss.equals("")) {
                ans += 1;
            }
        }
        return ans;
    }
}

/**
 * @author yujian
 * @since 2023/7/16 16:40
 * <p>
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。
 * 如果不存在这样的两个单词，返回 0 。
 */
public class Solution318 {
    private int convert(String s) {
        int bit = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            bit = bit | (1 << c);
        }
        return bit;
    }

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            bits[i] = convert(words[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        Solution318 solution318 = new Solution318();
        System.out.println(solution318.maxProduct(words));
    }
}

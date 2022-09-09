/**
 * @author yujian
 * @since 2022/9/9 10:51
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class Solution151 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].equals("")) {
                builder.append(split[i]);
                if (i != 0) {
                    builder.append(" ");
                }
            }
        }
        while (builder.charAt(0) == ' ') {
            builder.deleteCharAt(0);
        }
        while (builder.charAt(builder.length() - 1) == ' ') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution151().reverseWords("  hello world  "));
    }
}

/**
 * @author 11214
 * @since 2022/12/28 14:48
 * <p>
 * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 * 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 * 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 * 前缀和后缀在字符串中任意位置都不能有交集。
 * 前缀和后缀包含的所有字符都要相同。
 * 同时删除前缀和后缀。
 * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的最短长度。
 */
public class Solution1750 {
    public int minimumLength(String s) {
        StringBuilder builder = new StringBuilder(s);
        while (builder.length() > 1 && builder.charAt(0) == builder.charAt(builder.length() - 1)) {
            char c = builder.charAt(0);
            while (builder.length() != 0 && builder.charAt(0) == c) {
                builder.delete(0, 1);
            }
            while (builder.length() != 0 && builder.charAt(builder.length() - 1) == c) {
                builder.delete(builder.length() - 1, builder.length());
            }
        }
        return builder.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1750().minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}

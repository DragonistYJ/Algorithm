import java.util.*;

/**
 * @author yujian
 * @since 2022/11/26 15:30
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class Solution394 {
    public String decodeString(String s) {
        Stack<Character> chars = new Stack<>();
        Stack<Character> nums = new Stack<>();
        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                chars.push(s.charAt(i));
            } else if (Character.isDigit(s.charAt(i))) {
                nums.push(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                chars.push('[');
                nums.push('[');
            } else {
                nums.pop();
                while (!nums.isEmpty() && nums.peek() != '[') {
                    temp.add(nums.pop());
                }
                int time = 0;
                Collections.reverse(temp);
                for (Character c : temp) {
                    time = time * 10 + (c - '0');
                }
                temp.clear();

                while (chars.peek() != '[') {
                    temp.add(chars.pop());
                }
                chars.pop();
                Collections.reverse(temp);
                for (int j = 0; j < time; j++) {
                    chars.addAll(temp);
                }
                temp.clear();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution394().decodeString("20[leetcode]"));
    }
}

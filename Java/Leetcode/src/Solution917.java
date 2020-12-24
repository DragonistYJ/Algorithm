/*
NO917 仅仅反转字母
给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 */
public class Solution917 {
    public String reverseOnlyLetters(String S) {
        int left = 0;
        int right = S.length() - 1;
        StringBuilder builder = new StringBuilder(S);
        while (left < right) {
            while (left < right && left < S.length() && !Character.isLetter(S.charAt(left))) left += 1;
            while (left < right && !Character.isLetter(S.charAt(right))) right -= 1;
            String s = S.substring(left, left + 1);
            builder.replace(left, left + 1, S.substring(right, right + 1));
            builder.replace(right, right + 1, s);
            left += 1;
            right -= 1;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution917().reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}

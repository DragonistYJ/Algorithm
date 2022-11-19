import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/*
NO316 去除重复字母
给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        int[] lastAppear = new int[26];
        Arrays.fill(lastAppear, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            if (lastAppear[c] == -1) {
                lastAppear[c] = i;
            }
        }
        HashSet<Character> hashSet = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(aChar);
                hashSet.add(aChar);
                continue;
            }
            if (hashSet.contains(aChar)) continue;
            if (aChar > stack.peek()) {
                stack.push(aChar);
                hashSet.add(aChar);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > aChar && lastAppear[stack.peek() - 'a'] > i) {
                Character pop = stack.pop();
                hashSet.remove(pop);
            }
            stack.push(aChar);
            hashSet.add(aChar);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution316().removeDuplicateLetters("bbcaac"));
    }
}

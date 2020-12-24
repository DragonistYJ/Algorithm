import java.util.Stack;

/*
NO32 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
//        int index = 0;
//        int ans = 0;
//        while (index + ans < s.length()) {
//            while (index < s.length() && s.charAt(index) == ')') {
//                index += 1;
//            }
//            int k = index;
//            Stack<Character> stack = new Stack<>();
//            while (k < s.length()) {
//                if (s.charAt(k) == '(') {
//                    stack.push('(');
//                    k += 1;
//                } else if (!stack.empty()) {
//                    stack.pop();
//                    k += 1;
//                    if (ans == 0) ans = 2;
//                    if (stack.empty()) {
//                        ans = Math.max(ans, k - index);
//                    }
//                } else {
//                    break;
//                }
//            }
//            index = k;
//        }
//        return ans;
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution32().longestValidParentheses("(()"));
    }
}

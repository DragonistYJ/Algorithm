import java.util.Stack;

/**
 * @ClassName Solution921
 * @Author 11214
 * @Date 2020/6/1
 * @Description TODO
 */
public class Solution921 {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else {
                if (stack.peek() == '(') stack.pop();
                else stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution921().minAddToMakeValid("()"));
    }
}

import java.util.Stack;

/**
 * @ClassName Solution1003
 * @Author 11214
 * @Date 2020/6/2
 * @Description TODO
 */
public class Solution1003 {
    public boolean isValid(String S) {
        int n = S.length();
        if (n % 3 != 0 || S.charAt(0) == 'b' || S.charAt(1) == 'c') return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'a' || S.charAt(i) == 'b' || stack.size() < 2) {
                stack.push(S.charAt(i));
            } else {
                char pop2 = stack.pop();
                char pop1 = stack.pop();
                if (pop1 == 'a' && pop2 == 'b') continue;
                stack.push(pop1);
                stack.push(pop2);
                stack.push(S.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1003().isValid("abcabcababc"));
    }
}

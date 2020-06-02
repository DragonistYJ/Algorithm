import java.util.Stack;

/**
 * @ClassName Solution946
 * @Author 11214
 * @Date 2020/6/1
 * @Description TODO
 */
public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        int n = popped.length;
        while (j < n) {
            if (stack.isEmpty() || stack.peek() != popped[j]) {
                if (i == n) break;
                stack.push(pushed[i]);
                i += 1;
            } else if (stack.peek() == popped[j]) {
                stack.pop();
                j += 1;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {};
        int[] popped = {};
        System.out.println(new Solution946().validateStackSequences(pushed, popped));
    }
}

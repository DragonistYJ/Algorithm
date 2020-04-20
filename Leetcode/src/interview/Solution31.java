package interview;

import java.util.Stack;

/**
 * @ClassName Solution31
 * @Author 11214
 * @Date 2020/4/12
 * @Description TODO
 */
public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index += 1;
            }
        }
        return index == popped.length;
    }
}

package interview;

import java.util.Stack;

/**
 * @ClassName Solution9
 * @Author 11214
 * @Date 2020/4/11
 * @Description TODO
 */
public class Solution9 {
    static class CQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.add(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty()) return -1;
            while (stack1.size() > 1) {
                stack2.push(stack1.pop());
            }
            int value = stack1.pop();
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return value;
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Solutin225
 * @Author 11214
 * @Date 2020/6/11
 * @Description 用队列实现栈
 */
public class Solution225 {
    private class MyStack {
        private Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int n = queue.size();
            for (int i = 0; i < n - 1; i++) {
                queue.offer(queue.poll());
            }
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            int n = queue.size();
            for (int i = 0; i < n - 1; i++) {
                queue.offer(queue.poll());
            }
            int top = queue.poll();
            queue.offer(top);
            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

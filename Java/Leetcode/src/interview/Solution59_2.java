package interview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Solution59_2
 * @Author 11214
 * @Date 2020/4/13
 * @Description TODO
 */
class MaxQueue {
    private ArrayDeque<Integer> queue;
    private ArrayDeque<Integer> maxQueue;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) return -1;
        else return maxQueue.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int ret = queue.pollFirst();
        if (!maxQueue.isEmpty() && maxQueue.peekFirst() == ret) {
            maxQueue.pollFirst();
        }
        return ret;
    }
}

public class Solution59_2 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(2);
        maxQueue.push_back(1);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}

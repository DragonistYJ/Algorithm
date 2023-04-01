import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/4/1 14:08
 */
public class Solution41 {
    class MovingAverage {
        private ArrayDeque<Integer> deque;
        private int sum;
        private int size;

        public MovingAverage(int size) {
            deque = new ArrayDeque<>(size + 1);
            sum = 0;
            this.size = size;
        }

        public double next(int val) {
            deque.offerLast(val);
            sum += val;
            if (deque.size() > this.size) {
                sum -= deque.pollFirst();
            }
            return 1.0 * sum / deque.size();
        }
    }
}

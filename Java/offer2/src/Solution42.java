import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/4/1 14:12
 */
public class Solution42 {
    class RecentCounter {
        private ArrayDeque<Integer> deque;

        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            deque.offerLast(t);
            while (deque.peekFirst() < t - 3000) {
                deque.pollFirst();
            }
            return deque.size();
        }
    }
}

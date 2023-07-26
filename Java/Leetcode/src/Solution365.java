import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @author yujian
 * @since 2023/7/26 16:22
 * 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 * 你可以：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
public class Solution365 {
    static class State {
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State state)) return false;

            if (x != state.x) return false;
            return y == state.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        HashSet<State> states = new HashSet<>();
        Deque<State> deque = new ArrayDeque<>();
        State start = new State(0, 0);
        deque.add(start);
        while (!deque.isEmpty()) {
            State state = deque.pollFirst();
            if (state.x == targetCapacity || state.y == targetCapacity || state.x + state.y == targetCapacity) {
                return true;
            }
            if (states.contains(state)) {
                continue;
            }
            states.add(state);

            deque.offerLast(new State(state.x, jug2Capacity));
            deque.offerLast(new State(jug1Capacity, state.y));
            deque.offerLast(new State(state.x, 0));
            deque.offerLast(new State(0, state.y));
            deque.offerLast(new State(state.x - Math.min(state.x, jug2Capacity - state.y),
                    state.y + Math.min(state.x, jug2Capacity - state.y)));
            deque.offerLast(new State(state.x + Math.min(state.y, jug2Capacity - state.x),
                    state.y - Math.min(state.y, jug2Capacity - state.x)));
        }

        return false;
    }

    public static void main(String[] args) {
        Solution365 solution = new Solution365();
        System.out.println(solution.canMeasureWater(3, 5, 4));
    }
}

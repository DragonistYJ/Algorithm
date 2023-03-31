import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/3/31 15:16
 */
public class Solution38 {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                if (deque.isEmpty()) {
                    deque.offerLast(new int[]{temperatures[i], i});
                    break;
                }
                int[] ints = deque.peekLast();
                if (temperatures[i] <= ints[0]) {
                    deque.offerLast(new int[]{temperatures[i], i});
                    break;
                } else {
                    deque.pollLast();
                    ans[ints[1]] = i - ints[1];
                }
            }
        }
        return ans;
    }
}

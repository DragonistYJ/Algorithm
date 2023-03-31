import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/3/31 15:47
 */
public class Solution39 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        ArrayDeque<int[]> deque = new ArrayDeque<>(n);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int height = i == n ? 0 : heights[i];
            int[] pair = {height, i};
            while (true) {
                if (deque.isEmpty()) {
                    deque.offerLast(pair);
                    break;
                }
                int[] last = deque.peekLast();
                if (height <= last[0]) {
                    deque.pollLast();
                    pair[1] = last[1];
                    ans = Math.max(ans, (i - last[1]) * last[0]);
                } else {
                    deque.offerLast(pair);
                    break;
                }
            }
        }
        return ans;
    }
}

import java.util.ArrayDeque;

/**
 * @author 11214
 * @since 2023/3/31 15:02
 */
public class Solution37 {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(asteroids.length);
        for (int asteroid : asteroids) {
            if (deque.isEmpty()) {
                deque.offerLast(asteroid);
                continue;
            }
            while (true) {
                if (deque.isEmpty()) {
                    deque.offerLast(asteroid);
                    break;
                }

                Integer last = deque.peekLast();
                if (last < 0 || (last > 0 && asteroid > 0)) {
                    deque.offerLast(asteroid);
                    break;
                } else {
                    if (last == -asteroid) {
                        deque.pollLast();
                        break;
                    } else if (last <= -asteroid) {
                        deque.pollLast();
                    } else {
                        break;
                    }
                }
            }
        }
        int[] ans = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            ans[i] = deque.pollFirst();
            i += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution37().asteroidCollision(new int[]{10, 2, -5}));
    }
}

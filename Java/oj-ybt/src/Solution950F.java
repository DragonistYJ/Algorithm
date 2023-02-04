import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.PriorityQueue;

/**
 * @author 11214
 * @since 2023/2/4 11:20
 */
public class Solution950F {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Integer::compare);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            st.nextToken();
            int a = (int) st.nval;
            maxQueue.offer(a);
            minQueue.offer(a);
        }
        st.nextToken();

        while (maxQueue.size() > 1) {
            Integer a = maxQueue.poll();
            Integer b = maxQueue.poll();
            maxQueue.offer(a * b + 1);
        }
        while (minQueue.size() > 1) {
            Integer a = minQueue.poll();
            Integer b = minQueue.poll();
            minQueue.offer(a * b + 1);
        }
        System.out.println(maxQueue.poll() - minQueue.poll());
    }
}

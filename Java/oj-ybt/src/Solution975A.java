import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;


/**
 * @author 11214
 * @since 2023/3/6 10:04
 */
public class Solution975A {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = i;
            st.nextToken();
            nums[i][1] = (int) st.nval;
        }

        ArrayDeque<int[]> maxQueue = new ArrayDeque<>();
        maxQueue.offerLast(nums[0]);
        ArrayDeque<int[]> minQueue = new ArrayDeque<>();
        minQueue.offerLast(nums[0]);
        for (int i = 1; i < k; i++) {
            while (!maxQueue.isEmpty() && maxQueue.peekLast()[1] < nums[i][1]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(nums[i]);

            while (!minQueue.isEmpty() && minQueue.peekLast()[1] > nums[i][1]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[i]);
        }

        int[] maxes = new int[n - k + 1];
        maxes[0] = maxQueue.peekFirst()[1];
        int[] mines = new int[n - k + 1];
        mines[0] = minQueue.peekFirst()[1];
        for (int i = k; i < n; i++) {
            while (maxQueue.peekFirst()[0] <= i - k) {
                maxQueue.pollFirst();
            }
            while (!maxQueue.isEmpty() && maxQueue.peekLast()[1] < nums[i][1]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(nums[i]);
            maxes[i - k + 1] = maxQueue.peekFirst()[1];

            while (minQueue.peekFirst()[0] <= i - k) {
                minQueue.pollFirst();
            }
            while (!minQueue.isEmpty() && minQueue.peekLast()[1] > nums[i][1]) {
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[i]);
            mines[i - k + 1] = minQueue.peekFirst()[1];
        }


        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        for (int min : mines) {
            writer.write(min + " ");
        }
        writer.write("\n");
        for (int max : maxes) {
            writer.write(max + " ");
        }
        writer.flush();
        writer.close();
    }
}

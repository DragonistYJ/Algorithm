import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author 11214
 * @since 2023/4/4 11:46
 */
public class Solution61 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (queue.size() < k) {
                    queue.add(new int[]{num1 + num2, num1, num2});
                } else {
                    int[] peek = queue.peek();
                    int sum = num1 + num2;
                    if (sum >= peek[0]) {
                        break;
                    } else {
                        queue.add(new int[]{sum, num1, num2});
                        queue.poll();
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] ints : queue) {
            ans.add(new ArrayList<>(Arrays.asList(ints[1], ints[2])));
        }
        return ans;
    }
}

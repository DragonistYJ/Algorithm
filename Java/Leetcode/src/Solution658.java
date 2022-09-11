import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yujian
 * @since 2022/9/11 14:53
 * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。
 * 返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 */
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> nearQueue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1 - x);
            int abs2 = Math.abs(o2 - x);
            if (abs1 == abs2) {
                return o1 - o2;
            } else {
                return abs1 - abs2;
            }
        });
        PriorityQueue<Integer> numberQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i : arr) {
            nearQueue.offer(i);
        }
        for (int i = 0; i < k; i++) {
            numberQueue.offer(nearQueue.poll());
        }
        List<Integer> ans = new ArrayList<>();
        while (!numberQueue.isEmpty()) {
            ans.add(numberQueue.poll());
        }
        return ans;
    }
}

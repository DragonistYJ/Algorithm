import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName Solution1338
 * @Author 11214
 * @Date 2020/6/3
 * @Description 数组大小减半
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 */
public class Solution1338 {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = arr.length;
        for (int value : arr) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> hashMap.get(o2) - hashMap.get(o1));
        Set<Integer> keySet = hashMap.keySet();
        for (Integer key : keySet) {
            queue.offer(key);
        }
        int ans = 0;
        int sum = 0;
        while (sum < n / 2) {
            Integer poll = queue.poll();
            sum += hashMap.get(poll);
            ans += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 7, 7};
        System.out.println(new Solution1338().minSetSize(arr));
    }
}

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName Solution1306
 * @Author 11214
 * @Date 2020/6/8
 * @Description 跳跃游戏3
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 */
public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] reachable = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        reachable[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();
            if (arr[point] == 0) return true;
            int left = point - arr[point];
            int right = point + arr[point];
            if (left >= 0 && !reachable[left]) {
                reachable[left] = true;
                queue.offer(left);
            }
            if (right < n && !reachable[right]) {
                reachable[right] = true;
                queue.offer(right);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        System.out.println(new Solution1306().canReach(arr, 5));
    }
}

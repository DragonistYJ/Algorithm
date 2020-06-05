import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Solution1383
 * @Author 11214
 * @Date 2020/6/5
 * @Description 最大的团队表现值
 * 公司有编号为 1 到 n 的 n 个工程师，给你两个数组 speed 和 efficiency ，其中 speed[i] 和 efficiency[i] 分别代表第 i 位工程师的速度和效率。
 * 请你返回由最多 k 个工程师组成的 ​​​​​​最大团队表现值 ，由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
 * 团队表现值 的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」。
 */
public class Solution1383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] pair = new int[n][2];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < n; i++) {
            pair[i][0] = speed[i];
            pair[i][1] = efficiency[i];
        }
        Arrays.sort(pair, (o1, o2) -> o2[1] - o1[1]);

        long speedSum = pair[0][0];
        long ans = speedSum * pair[0][1];
        queue.offer(pair[0][0]);
        for (int i = 1; i < n; i++) {
            if (queue.size() < k) {
                queue.offer(pair[i][0]);
                speedSum += pair[i][0];
            } else {
                int poll = queue.poll();
                int max = Math.max(poll, pair[i][0]);
                speedSum = speedSum - poll + max;
                queue.offer(max);
            }
            ans = Math.max(ans, speedSum * pair[i][1]);
        }

        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {
        int[] speed = {1};
        int[] efficiency = {8};
        System.out.println(new Solution1383().maxPerformance(1, speed, efficiency, 1));
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName Solution1353
 * @Author 11214
 * @Date 2020/6/4
 * @Description 最多可以参加的会议数目
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * 请你返回你可以参加的 最大 会议数目。
 */
public class Solution1353 {
    public int maxEvents(int[][] events) {
        int n = events.length;
        List<List<Integer>> eventList = new ArrayList<>();
        int end = 0;
        for (int[] event : events) {
            List<Integer> list = new ArrayList<>();
            list.add(event[0]);
            list.add(event[1]);
            end = Math.max(end, event[1]);
            eventList.add(list);
        }
        eventList.sort((o1, o2) -> o1.get(0).equals(o2.get(0)) ? o1.get(1) - o2.get(1) : o1.get(0) - o2.get(0));
        int day = 1;
        int ans = 0;
        int index = 0;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.get(1) - o2.get(1));
        while (day <= end) {
            while (index < n && eventList.get(index).get(0) <= day) {
                queue.offer(eventList.get(index));
                index += 1;
            }
            while (!queue.isEmpty() && queue.peek().get(1) < day) queue.poll();
            if (!queue.isEmpty()) {
                queue.poll();
                ans += 1;
            }
            day += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] events = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};
        System.out.println(new Solution1353().maxEvents(events));
    }
}

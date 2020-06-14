import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @ClassName Solution327
 * @Author 11214
 * @Date 2020/4/16
 * @Description 我的日程安排表3
 * 实现一个 MyCalendar 类来存放你的日程安排，你可以一直添加新的日程安排。
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在start到end时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * 当 K 个日程安排有一些时间上的交叉时（例如K个日程安排都在同一时间内），就会产生 K 次预订。
 * 每次调用 MyCalendar.book方法时，返回一个整数 K ，表示最大的 K 次预订。
 */
public class Solution732 {
    private static class MyCalendarThree {
        private final TreeMap<Integer, Integer> delta;

        public MyCalendarThree() {
            delta = new TreeMap<>();
        }

        public int book(int start, int end) {
            delta.put(start, delta.getOrDefault(start, 0) + 1);
            delta.put(end, delta.getOrDefault(end, 0) - 1);

            int active = 0, ans = 0;
            for (int d : delta.values()) {
                active += d;
                ans = Math.max(ans, active);
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        System.out.println(myCalendarThree.book(10, 20));
    }
}

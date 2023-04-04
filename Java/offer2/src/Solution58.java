import java.util.TreeSet;

/**
 * @author 11214
 * @since 2023/4/4 10:54
 */
public class Solution58 {
    class MyCalendar {
        private final TreeSet<int[]> treeSet;

        public MyCalendar() {
            treeSet = new TreeSet<>((o1, o2) -> {
                if ((o1[1] > o2[0] && o1[1] <= o2[1]) || (o2[1] > o1[0] && o2[1] <= o1[1])) {
                    return 0;
                }
                if (o1[1] <= o2[0]) {
                    return -1;
                } else {
                    return 1;
                }
            });
        }

        public boolean book(int start, int end) {
            int[] entry = new int[]{start, end};
            if (treeSet.contains(entry)) {
                return false;
            }
            treeSet.add(entry);
            return true;
        }
    }
}

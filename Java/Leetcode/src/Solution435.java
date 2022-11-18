import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 11214
 * @since 2022/11/18 14:57
 * <p>
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> intervalList = Arrays.stream(intervals).sorted((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        }).collect(Collectors.toList());
        int total = 0;
        int right = Integer.MIN_VALUE;
        for (int[] ints : intervalList) {
            if (ints[0] >= right) {
                total += 1;
                right = ints[1];
            }
        }
        return intervals.length - total;
    }

    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
        int[][] intervals = new int[][]{{0, 2}, {1, 3}, {1, 3}, {2, 4}, {3, 5}, {3, 5}, {4, 6}};
        System.out.println(solution435.eraseOverlapIntervals(intervals));
    }
}

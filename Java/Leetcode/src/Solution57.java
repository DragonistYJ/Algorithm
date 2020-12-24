/*
NO57 插入区间
给出一个无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = 0;
        int right = intervals.length - 1;
        while (left < intervals.length && newInterval[0] > intervals[left][1]) left += 1;
        while (right >= 0 && newInterval[1] < intervals[right][0]) right -= 1;
        if (left > right) {
            int[][] ans = new int[intervals.length + 1][2];
            for (int i = 0; i <= right; i++) {
                ans[i][0] = intervals[i][0];
                ans[i][1] = intervals[i][1];
            }
            ans[left][0] = newInterval[0];
            ans[left][1] = newInterval[1];
            for (int i = left; i < intervals.length; i++) {
                ans[i + 1][0] = intervals[i][0];
                ans[i + 1][1] = intervals[i][1];
            }
            return ans;
        }
        if (left == right) {
            int[][] ans = new int[intervals.length][2];
            for (int i = 0; i < intervals.length; i++) {
                ans[i][0] = intervals[i][0];
                ans[i][1] = intervals[i][1];
            }
            ans[left][0] = Math.min(intervals[left][0], newInterval[0]);
            ans[right][1] = Math.max(intervals[left][1], newInterval[1]);
            return ans;
        }
        int[][] ans = new int[intervals.length - (right - left)][2];
        for (int i = 0; i < left; i++) {
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }
        ans[left][0] = Math.min(intervals[left][0], newInterval[0]);
        ans[left][1] = Math.max(intervals[right][1], newInterval[1]);
        int x = right - left;
        for (int i = right + 1; i < intervals.length; i++) {
            ans[i - x][0] = intervals[i][0];
            ans[i - x][1] = intervals[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{};
        int[] newInterval = new int[]{3, 4};
        int[][] insert = new Solution57().insert(intervals, newInterval);
        for (int[] ints : insert) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
        System.out.println();
    }
}

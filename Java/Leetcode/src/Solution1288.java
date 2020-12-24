import java.util.*;

/*
NO1288 删除被覆盖区间
给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
在完成所有删除操作后，请你返回列表中剩余区间的数目。
 */
public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        List<Pair> pairs = new ArrayList<>();
        for (int[] interval : intervals) {
            pairs.add(new Pair(interval[0], interval[1]));
        }
        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.left == o2.left) {
                    return o2.right - o1.right;
                } else {
                    return o1.left - o2.left;
                }
            }
        });
        int index = 1;
        while (index < pairs.size()) {
            Pair pre = pairs.get(index - 1);
            Pair current = pairs.get(index);
            if (current.right <= pre.right) {
                pairs.remove(index);
            } else {
                index += 1;
            }
        }
        return pairs.size();
    }

    private class Pair {
        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[][] x = {{1, 4}, {3, 6}, {2, 8}, {1, 6}};
        System.out.println(new Solution1288().removeCoveredIntervals(x));
    }
}

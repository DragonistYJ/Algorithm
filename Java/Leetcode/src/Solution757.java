import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
NO757 设置交集大小至少为2
一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
输出这个最小集合S的大小。
 */
public class Solution757 {
    public int intersectionSizeTwo(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) return 0;
        ArrayList<Pair> pairs = new ArrayList<>();
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
        int ans = 0;
        int[] todo = new int[len];
        Arrays.fill(todo, 2);
        for (int i = len - 1; i >= 0; i--) {
            int left = pairs.get(i).left;
            int steps = todo[i];
            for (int j = left; j < left + steps; j++) {
                for (int k = 0; k < i; k++) {
                    if (todo[k] > 0 && pairs.get(k).right >= j && j >= pairs.get(k).left) {
                        todo[k] -= 1;
                    }
                }
                ans += 1;
            }
        }
        return ans;
    }

    private class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[][] x = {{1, 2}, {2, 3}, {2, 4}, {4, 5}};
        System.out.println(new Solution757().intersectionSizeTwo(x));
    }
}

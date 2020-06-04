import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution1326
 * @Author 11214
 * @Date 2020/6/4
 * @Description 灌溉花园的最少水龙头数目
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 */
public class Solution1326 {
    public int minTaps(int n, int[] ranges) {
        List<List<Integer>> rangeList = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            List<Integer> list = new ArrayList<>();
            list.add(Math.max(i - ranges[i], 0));
            list.add(Math.min(i + ranges[i], n));
            rangeList.add(list);
        }
        rangeList.sort((o1, o2) -> o1.get(0).equals(o2.get(0)) ? o1.get(1) - o2.get(1) : o1.get(0) - o2.get(0));

        int ans = 0;
        int start = 0;
        int index = 0;
        while (start < n) {
            int temp = start;
            while (index < rangeList.size() && rangeList.get(index).get(0) <= start) {
                temp = Math.max(temp, rangeList.get(index).get(1));
                index += 1;
            }
            if (start == temp) break;
            start = temp;
            ans += 1;
        }

        if (start < n) return -1;
        else return ans;
    }

    public static void main(String[] args) {
        int[] ranges = {1, 0, 0, 1};
        System.out.println(new Solution1326().minTaps(3, ranges));
    }
}

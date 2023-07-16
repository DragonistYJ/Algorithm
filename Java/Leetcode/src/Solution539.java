import java.util.List;

/**
 * @author yujian
 * @since 2023/7/16 16:48
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 */
public class Solution539 {
    private int convert(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        return h * 60 + m;
    }

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] times = new int[n];
        for (int i = 0; i < timePoints.size(); i++) {
            times[i] = convert(timePoints.get(i));
        }
        int res = 1440;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = Math.abs(times[i] - times[j]);
                int b = 1440 - a;
                res = Math.min(res, Math.min(a, b));
            }
        }
        return res;
    }
}

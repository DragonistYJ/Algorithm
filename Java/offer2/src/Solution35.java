import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 11214
 * @since 2023/3/31 14:37
 */
public class Solution35 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        List<Integer> list = new ArrayList<>(n);
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            list.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        list.sort(Integer::compareTo);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = list.get(i);
            int b = list.get((i + 1) % n);
            min = Math.min(min, Math.min(Math.abs(b - a), 1440 - Math.abs((b - a))));
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution35().findMinDifference(Arrays.asList("00:00", "04:00", "22:00")));
    }
}

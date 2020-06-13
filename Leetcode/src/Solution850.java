import java.util.*;

/**
 * @ClassName Solution307
 * @Author 11214
 * @Date 2020/6/13
 * @Description 矩形面积2
 * 我们给出了一个（轴对齐的）矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是矩形 i 左下角的坐标，（x2，y2）是该矩形右上角的坐标。
 * 找出平面中所有矩形叠加覆盖后的总面积。 由于答案可能太大，请返回它对 10 ^ 9 + 7 取模的结果。
 */
public class Solution850 {
    public int rectangleArea(int[][] rectangles) {
        Arrays.sort(rectangles, (o1, o2) -> o1[1] == o2[1] ? o1[3] - o2[3] : o1[1] - o2[1]);

        int n = rectangles.length;
        Set<Integer> set = new HashSet<>();
        for (int[] rectangle : rectangles) {
            set.add(rectangle[0]);
            set.add(rectangle[2]);
        }
        List<Integer> xAxises = new ArrayList<>(set);
        xAxises.sort(Comparator.comparingInt(o -> o));

        long ans = 0;
        int gaps = xAxises.size();
        for (int i = 0; i < gaps - 1; i++) {
            long sum = 0;
            int left = -1;
            int right = -1;
            for (int[] rectangle : rectangles) {
                if (rectangle[0] <= xAxises.get(i) && rectangle[2] >= xAxises.get(i + 1)) {
                    if (rectangle[1] >= right) {
                        sum = sum + right - left;
                        left = rectangle[1];
                        right = rectangle[3];
                    } else if (rectangle[3] > right) {
                        right = rectangle[3];
                    }
                }
            }
            sum = sum + right - left;
            ans = (ans + sum * (xAxises.get(i + 1) - xAxises.get(i))) % 1_000_000_007;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int[][] rectangles = { { 0, 0, 1000000000, 1000000000 } };
        System.out.println(new Solution850().rectangleArea(rectangles));
    }
}

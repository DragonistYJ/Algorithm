/**
 * @ClassName Solution1232
 * @Author 11214
 * @Date 2020/6/24
 * @Description 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 */
public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2)
            return true;

        int a = coordinates[0][1] - coordinates[1][1];
        int b = coordinates[1][0] - coordinates[0][0];
        int c = coordinates[0][0] * coordinates[1][1] - coordinates[1][0] * coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            int ans = a * coordinates[i][0] + b * coordinates[i][1] + c;
            if (ans != 0)
                return false;
        }

        return true;
    }
}

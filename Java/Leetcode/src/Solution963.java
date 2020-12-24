import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution963
 * @Author 11214
 * @Date 2020/6/24
 * @Description 最小矩形面积2
 * 给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。
 * 如果没有任何矩形，就返回 0。
 */
public class Solution963 {
    public double minAreaFreeRect(int[][] points) {
        int N = points.length;

        Point[] A = new Point[N];
        Set<Point> pointSet = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            A[i] = new Point(points[i][0], points[i][1]);
            pointSet.add(A[i]);
        }

        double ans = Double.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            Point p1 = A[i];
            for (int j = 0; j < N; ++j) if (j != i) {
                Point p2 = A[j];
                for (int k = j+1; k < N; ++k) if (k != i) {
                    Point p3 = A[k];
                    Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);

                    if (pointSet.contains(p4)) {
                        int dot = ((p2.x - p1.x) * (p3.x - p1.x) +
                                (p2.y - p1.y) * (p3.y - p1.y));
                        if (dot == 0) {
                            double area = p1.distance(p2) * p1.distance(p3);
                            if (area < ans)
                                ans = area;
                        }
                    }
                }
            }
        }

        return ans < Double.MAX_VALUE ? ans : 0;
    }
}

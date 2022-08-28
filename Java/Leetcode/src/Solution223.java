/**
 * @author 11214
 * @since 2022/8/28 11:41
 * 给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 */
public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int width = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int height = Math.min(ay2, by2) - Math.max(ay1, by1);
        int sum = (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1);
        if (width > 0 && height > 0) {
            sum -= width * height;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution223 solution223 = new Solution223();
        System.out.println(solution223.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
